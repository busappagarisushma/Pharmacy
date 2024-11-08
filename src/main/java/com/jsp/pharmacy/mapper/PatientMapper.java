package com.jsp.pharmacy.mapper;

import org.springframework.stereotype.Component;

import com.jsp.pharmacy.entity.Patient;
import com.jsp.pharmacy.entity.Pharmacy;
import com.jsp.pharmacy.requestdto.PatientRequest;
import com.jsp.pharmacy.requestdto.PharmacyRequest;
import com.jsp.pharmacy.responsedto.PatientResponse;
import com.jsp.pharmacy.responsedto.PharmacyResponse;

@Component
public class PatientMapper {

public Patient mapToPatient(PatientRequest patientRequest,Patient patient) {
		
		patient.setName(patientRequest.getName());
		patient.setPhoneNumber(patient.getPhoneNumber());
		patient.setEmail(patientRequest.getEmail());
		patient.setGender(patientRequest.getGender());
		patient.setDate(patientRequest.getDate());
		
		return patient;
	}
	
	public PatientResponse mapToPatientResponse(Patient patient) {
		
		PatientResponse response = new PatientResponse();
		
		response.setPatientId(patient.getPatientId());
		response.setName(patient.getName());
		response.setEmail(patient.getEmail());
		return response;
	}
}
