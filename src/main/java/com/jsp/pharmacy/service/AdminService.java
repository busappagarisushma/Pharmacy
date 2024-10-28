package com.jsp.pharmacy.service;

import org.springframework.http.ResponseEntity;

import com.jsp.pharmacy.entity.Admin;
import com.jsp.pharmacy.repo.AdminRepository;
import com.jsp.pharmacy.util.ResponseStructure;

public class AdminService {

	private final AdminRepository adminRepository;

	public AdminService(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}

	 public ResponseEntity<ResponseStructure<Admin>> getAdminById(String adminId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
