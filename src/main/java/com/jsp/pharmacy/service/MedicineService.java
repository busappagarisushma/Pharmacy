package com.jsp.pharmacy.service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

//import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jsp.pharmacy.entity.Medicine;
import com.jsp.pharmacy.entity.Pharmacy;
import com.jsp.pharmacy.enums.Form;
import com.jsp.pharmacy.exception.NoMedicineFoundException;
import com.jsp.pharmacy.exception.PharmacyNotFoundByIdException;
import com.jsp.pharmacy.mapper.MedicineMapper;
import com.jsp.pharmacy.repo.MedicineRepository;
import com.jsp.pharmacy.repo.PharmacyRepository;
import com.jsp.pharmacy.responsedto.MedicineResponse;

import jakarta.transaction.Transactional;

@Service
public class MedicineService {

	private final MedicineRepository medicineRepository;
	private final PharmacyRepository pharmacyRepository;
	private final MedicineMapper medicineMapper;



	public MedicineService(MedicineRepository medicineRepository, PharmacyRepository pharmacyRepository,
			MedicineMapper medicineMapper) {
		super();
		this.medicineRepository = medicineRepository;
		this.pharmacyRepository = pharmacyRepository;
		this.medicineMapper = medicineMapper;
	}


	@Transactional
	public String uploadMedicines(MultipartFile file,String pharmacyId) {
		List<Medicine> medicines = new ArrayList<>();

		Pharmacy pharmacy = pharmacyRepository.findById(pharmacyId)
				.orElseThrow(()->new PharmacyNotFoundByIdException("Failed to upload due to no Pharmacy found by Id "+pharmacyId));

		try (XSSFWorkbook workBook= new XSSFWorkbook(file.getInputStream())){

			for(Sheet sheet : workBook) {
				for(Row row : sheet) {
					if(row.getRowNum() != 0) {
						Medicine medicine = new Medicine();
						medicine.setName(row.getCell(0).getStringCellValue());
						medicine.setCategory(row.getCell(1).getStringCellValue());
						medicine.setDoasageInMg((int) row.getCell(2).getNumericCellValue());



						String formValue = row.getCell(3).getStringCellValue();
						medicine.setForm(Form.valueOf(formValue.toUpperCase()));

						medicine.setIngredients(row.getCell(4).getStringCellValue());

						medicine.setManfucaturer(row.getCell(5).getStringCellValue());
						medicine.setStockQuantity(10);
						medicine.setPrice(row.getCell(6).getNumericCellValue());

						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						medicine.setExpiryDate(LocalDate.parse(row.getCell(7).getStringCellValue(), formatter));



						medicine.setPharmacy(pharmacy);

						medicines.add(medicine);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		medicineRepository.saveAll(medicines);
		return "Uploaded " + medicines.size() + " medicines successfully!";

	}

	public List<MedicineResponse> findMedicineByNameLikeOrIngredientsLike(String name,String ingredient) {
		List<Medicine> medicines = medicineRepository.findMedicineByNameLikeIgnoreCaseOrIngredientsLikeIgnoreCase(name,ingredient);

		if (medicines.isEmpty()) {
			throw new NoMedicineFoundException("No medicines found with input: "+name+" or "+ingredient);
		}

		return medicines.stream()
				.map(medicineMapper::mapToMedicineResponse) 
				.toList();
	}


}



