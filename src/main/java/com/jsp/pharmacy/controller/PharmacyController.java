package com.jsp.pharmacy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.pharmacy.requestdto.PharmacyRequest;
import com.jsp.pharmacy.responsedto.PharmacyResponse;
import com.jsp.pharmacy.service.PharmacyService;
import com.jsp.pharmacy.util.AppResponseBuilder;
import com.jsp.pharmacy.util.ResponseStructure;

@RestController
public class PharmacyController {

	private final PharmacyService pharmacyService;
	private final AppResponseBuilder appResponseBuilder;
	
	public PharmacyController(PharmacyService pharmacyService, AppResponseBuilder appResponseBuilder) {
		super();
		this.pharmacyService = pharmacyService;
		this.appResponseBuilder = appResponseBuilder;
	}

	@PostMapping("/admins/{adminId}/pharmacy")
	public ResponseEntity<ResponseStructure<PharmacyResponse>> savePharmacy(@RequestBody PharmacyRequest pharmacyRequest,
			@PathVariable String adminId){
		PharmacyResponse pharmacyResponse = pharmacyService.savePharmacy(pharmacyRequest,adminId);
		return appResponseBuilder.success(HttpStatus.CREATED,"Pharmacy Added", pharmacyResponse);
	}
	
}
