package com.jsp.pharmacy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jsp.pharmacy.entity.Patient;
import com.jsp.pharmacy.exception.NoPatientFoundException;
import com.jsp.pharmacy.exception.PatientNotFoundByIdException;
import com.jsp.pharmacy.exception.PharmacyNotFoundByIdException;
import com.jsp.pharmacy.mapper.PatientMapper;
import com.jsp.pharmacy.repo.PatientRepository;
import com.jsp.pharmacy.repo.PharmacyRepository;
import com.jsp.pharmacy.requestdto.PatientRequest;
import com.jsp.pharmacy.responsedto.PatientResponse;

@Service
public class PatientService {

	private final PatientRepository patientRepository;
	private final PharmacyRepository pharmacyRepository;
	private final PatientMapper patientMapper;



	public PatientService(PatientRepository patientRepository, PharmacyRepository pharmacyRepository,
			PatientMapper patientMapper) {
		super();
		this.patientRepository = patientRepository;
		this.pharmacyRepository = pharmacyRepository;
		this.patientMapper = patientMapper;
	}



	public PatientResponse savePatient(PatientRequest patientRequest, String pharmacyId) {
		return pharmacyRepository.findById(pharmacyId).map((pharamcy)->{
			Patient patient = patientMapper.mapToPatient(patientRequest, new Patient());
			patient.setPharmacy(pharamcy);

			if(pharamcy.getPatients() == null) 
				pharamcy.setPatients(new ArrayList<>());

			pharamcy.getPatients().add(patient);
			patient=patientRepository.save(patient);
			return patientMapper.mapToPatientResponse(patient);

		}).orElseThrow(() -> new PharmacyNotFoundByIdException("Failed to add patient beacause pharmacy id not there"));
	}

	public List<PatientResponse> findAllPatientsByPharmacy(String pharmacyId) {
		List<Patient> patients = patientRepository.findPatientsByPharmacy(pharmacyId);
		if(patients.isEmpty())
			throw new NoPatientFoundException("Failed to find all Pharmacy");
		return patients.stream()
				.map(patientMapper::mapToPatientResponse)
				.toList();
	}


	public PatientResponse updatePatient(PatientRequest patientRequest, String patientId) {

		return patientRepository.findById(patientId).map((patient)->{
			patient = patientRepository.save(patientMapper.mapToPatient(patientRequest, patient));
			return patientMapper.mapToPatientResponse(patient);
		})
				.orElseThrow(()-> new PatientNotFoundByIdException("Failed to update Patient By Id"));
	}

}
