package com.jsp.pharmacy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.pharmacy.requestdto.PatientRequest;
import com.jsp.pharmacy.responsedto.PatientResponse;
import com.jsp.pharmacy.service.PatientService;
import com.jsp.pharmacy.util.AppResponseBuilder;
import com.jsp.pharmacy.util.ResponseStructure;

@RestController
public class PatientController {

	private final PatientService patientService;
	private final AppResponseBuilder appResponseBuilder;
	public PatientController(PatientService patientService, AppResponseBuilder appResponseBuilder) {
		super();
		this.patientService = patientService;
		this.appResponseBuilder = appResponseBuilder;
	}
	
	@PostMapping("/pharmacy/{pharmacyId}/patients")
	public ResponseEntity<ResponseStructure<PatientResponse>> savePatient(@RequestBody PatientRequest patientRequest,
			@PathVariable String pharmacyId){
		PatientResponse patientResponse = patientService.savePatient(patientRequest,pharmacyId);
		return appResponseBuilder.success(HttpStatus.CREATED, "patient created", patientResponse);
	}
}
