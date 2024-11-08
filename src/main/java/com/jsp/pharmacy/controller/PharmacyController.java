package com.jsp.pharmacy.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	
	@GetMapping("/pharmacy")
	public ResponseEntity<ResponseStructure<List<PharmacyResponse>>> findAllPharmacy(){
		List<PharmacyResponse> 	pharmacyResponses = pharmacyService.findAllPharmacy();
		return appResponseBuilder.success(HttpStatus.FOUND, "pharmacies Found", pharmacyResponses);
	}
	
	@GetMapping("/admins/{adminId}/pharmacy")
	public ResponseEntity<ResponseStructure<PharmacyResponse>> findPharmacy(@PathVariable String adminId){
		PharmacyResponse pharmacyResponse = pharmacyService.findPharmacy(adminId);
		return appResponseBuilder.success(HttpStatus.FOUND, "Pharmacy Found", pharmacyResponse);
	}
	
	
	@PutMapping("/pharmacy/{pharmacyId}")
	public ResponseEntity<ResponseStructure<PharmacyResponse>> updatePharmacy(@RequestBody PharmacyRequest pharmacyRequest,
			@PathVariable String pharmacyId){
		PharmacyResponse  pharmacyResponse = pharmacyService.updatePharmacy(pharmacyRequest,pharmacyId);
		return appResponseBuilder.success(HttpStatus.OK,"Updated Pharmacy", pharmacyResponse);		
	}
		
}
