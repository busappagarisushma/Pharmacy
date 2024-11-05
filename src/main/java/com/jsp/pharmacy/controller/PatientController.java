package com.jsp.pharmacy.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/patients/{pharmacyId}")
	public ResponseEntity<ResponseStructure<List<PatientResponse>>> findAllPatientsByPharmacy(@PathVariable String pharmacyId){
		List<PatientResponse> response=patientService.findAllPatientsByPharmacy(pharmacyId);
		return appResponseBuilder.success(HttpStatus.FOUND, "Patients Founded", response);
		
	} 

}
