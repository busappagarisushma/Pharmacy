package com.jsp.pharmacy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jsp.pharmacy.service.MedicineService;
import com.jsp.pharmacy.util.AppResponseBuilder;
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


	@PostMapping("medicines/upload")
	public ResponseEntity<SimpleResponseStructure> uploadMedicines(@RequestParam MultipartFile file){
		String medicines = medicineService.uploadMedicines(file);
		return appResponseBuilder.success(HttpStatus.CREATED, medicines);
	}



}
