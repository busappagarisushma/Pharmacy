package com.jsp.pharmacy.service;

import com.jsp.pharmacy.repo.AdminRepository;

public class AdminService {

	private final AdminRepository adminRepository;

	public AdminService(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}
	
	
}
