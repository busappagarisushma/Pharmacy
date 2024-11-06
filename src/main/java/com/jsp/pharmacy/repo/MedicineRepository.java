package com.jsp.pharmacy.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.pharmacy.controller.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, String>{

}
