package com.jsp.pharmacy.mapper;

import org.springframework.stereotype.Component;

import com.jsp.pharmacy.entity.Medicine;
import com.jsp.pharmacy.requestdto.MedicineRequest;
import com.jsp.pharmacy.responsedto.MedicineResponse;

@Component
public class MedicineMapper {

	public Medicine mapToMedicine(MedicineRequest request,Medicine medicine) {
		medicine.setName(request.getName());
		medicine.setCategory(request.getCategory());
		medicine.setIngredients(request.getIngredients());
		medicine.setDoasageInMg(request.getDoasageInMg());
		medicine.setForm(request.getForm());
		medicine.setManfucaturer(request.getManfucaturer());
		medicine.setStockQuantity(request.getStockQuantity());
		medicine.setExpiryDate(request.getExpiryDate());
		medicine.setPrice(request.getPrice());

		return  medicine;
	}

	public MedicineResponse mapToMedicineResponse(Medicine medicine) {

		MedicineResponse response = new MedicineResponse();

		response.setMedicineId(medicine.getMedicineId());
		response.setName(medicine.getName());
		response.setCategory(medicine.getCategory());
		response.setIngredients(medicine.getIngredients());
		response.setDoasageInMg(medicine.getDoasageInMg());
		response.setForm(medicine.getForm());
		response.setManfucaturer(medicine.getManfucaturer());
		response.setStockQuantity(medicine.getStockQuantity());
		response.setExpiryDate(medicine.getExpiryDate());
		response.setPrice(medicine.getPrice());

		return response;
	}
}
