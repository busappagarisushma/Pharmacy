package com.jsp.pharmacy.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.pharmacy.entity.Pharmacy;

public interface PharmacyRepository extends JpaRepository<Pharmacy, String>{

}
