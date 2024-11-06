package com.jsp.pharmacy.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jsp.pharmacy.responsedto.MedicineResponse;
import com.jsp.pharmacy.service.MedicineService;
import com.jsp.pharmacy.util.AppResponseBuilder;
import com.jsp.pharmacy.util.ResponseStructure;
import com.jsp.pharmacy.util.SimpleResponseStructure;

@RestController
public class MedicineController {

	private final MedicineService medicineService;
	private final AppResponseBuilder appResponseBuilder;


	public MedicineController(MedicineService medicineService, AppResponseBuilder appResponseBuilder) {
		super();
		this.medicineService = medicineService;
		this.appResponseBuilder = appResponseBuilder;
	}


	@PostMapping("/pharmacy/{pharmacyId}/medicines/upload")
	public ResponseEntity<SimpleResponseStructure> uploadMedicines(@RequestParam MultipartFile file,@PathVariable String pharmacyId){
		String medicines = medicineService.uploadMedicines(file,pharmacyId);
		return appResponseBuilder.success(HttpStatus.CREATED, medicines);
	}


	@GetMapping("/medicines/{input}")
	public ResponseEntity<ResponseStructure<List<MedicineResponse>>> findMedicineByNameOrIngredient(@PathVariable String input){
		List<MedicineResponse> response =	medicineService.findMedicineByNameOrIngredient(input);
		return appResponseBuilder.success(HttpStatus.FOUND, "Medicine Found", response);
	}

}
