package com.jsp.pharmacy.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jsp.pharmacy.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, String>{

	@Query("SELECT p FROM Patient p WHERE p.pharmacy.pharmacyId = :pharmacyId")
	public List<Patient> findPatientsByPharmacy(@Param("pharmacyId")String pharmacyId);
}
