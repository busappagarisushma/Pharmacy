package com.jsp.pharmacy.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jsp.pharmacy.entity.Admin;
import com.jsp.pharmacy.entity.Pharmacy;

public interface AdminRepository extends JpaRepository<Admin, String>{

	@Query("SELECT p.pharmacy FROM Admin p WHERE p.adminId = :adminId")
	public Optional<Pharmacy> findPharmacyByAdminId(@Param("adminId")String adminId);


	public Optional<Admin> findByEmail(String email);
}
