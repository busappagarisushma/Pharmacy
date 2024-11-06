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
import com.jsp.pharmacy.enums.Form;
import com.jsp.pharmacy.repo.MedicineRepository;
import com.jsp.pharmacy.repo.PharmacyRepository;

@Service
public class MedicineService {

	private final MedicineRepository medicineRepository;
	private final PharmacyRepository pharmacyRepository;



	public MedicineService(MedicineRepository medicineRepository, PharmacyRepository pharmacyRepository) {
		super();
		this.medicineRepository = medicineRepository;
		this.pharmacyRepository = pharmacyRepository;
	}


	public String uploadMedicines(MultipartFile file) {
		List<Medicine> medicines = new ArrayList<>();

		try (XSSFWorkbook workBook = new XSSFWorkbook(file.getInputStream())) {
			for (Sheet sheet : workBook) {
				for (Row row : sheet) {
					if (row.getRowNum() != 0) { // Skip header row
						Medicine medicine = new Medicine();

						// Reading values from Excel file and setting properties for the Medicine object
						medicine.setName(row.getCell(0).getStringCellValue());
						medicine.setCategory(row.getCell(1).getStringCellValue());
						medicine.setDoasageInMg((int) row.getCell(2).getNumericCellValue());

						// Parsing form type (e.g., tablet, syrup) from Excel value
						String formValue = row.getCell(3).getStringCellValue();
						medicine.setForm(Form.valueOf(formValue.toUpperCase()));

						medicine.setIngredients(row.getCell(4).getStringCellValue());
						medicine.setManfucaturer(row.getCell(5).getStringCellValue());
						medicine.setStockQuantity(10);  // Default value or can be set dynamically
						medicine.setPrice(row.getCell(6).getNumericCellValue());

						// Parsing the expiry date from the Excel file
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						medicine.setExpiryDate(LocalDate.parse(row.getCell(7).getStringCellValue(), formatter));

						// You can leave the pharmacy field as null or use a default static value if needed
						// For now, we leave it without setting the pharmacy (or could use a default one)

						medicines.add(medicine);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Save all the medicines to the database
		medicineRepository.saveAll(medicines);

		return "Uploaded " + medicines.size() + " medicines successfully!";
	}

}
