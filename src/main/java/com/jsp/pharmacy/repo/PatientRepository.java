package com.jsp.pharmacy.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.pharmacy.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, String>{

}
