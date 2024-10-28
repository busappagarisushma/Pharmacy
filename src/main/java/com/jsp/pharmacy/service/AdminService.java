package com.jsp.pharmacy.service;

import com.jsp.pharmacy.entity.Admin;
import com.jsp.pharmacy.exception.AdminNotFoundByIdException;
import com.jsp.pharmacy.mapper.AdminMapper;
import com.jsp.pharmacy.repo.AdminRepository;
import com.jsp.pharmacy.requestdto.AdminRequest;
import com.jsp.pharmacy.responsedto.AdminResponse;
import com.jsp.pharmacy.util.AppResponseBuilder;

public class AdminService {

	private final AdminRepository adminRepository;
	private final AppResponseBuilder appResponseBuilder;
	private final AdminMapper adminMapper;
	
	
	public AdminService(AdminRepository adminRepository, AppResponseBuilder appResponseBuilder,
			AdminMapper adminMapper) {
		super();
		this.adminRepository = adminRepository;
		this.appResponseBuilder = appResponseBuilder;
		this.adminMapper = adminMapper;
	}


	public AdminResponse findByAdminId(String  adminId) {

		return adminRepository.findById(adminId)
				.map(adminMapper :: mapToUserResponse)
				.orElseThrow(() -> new AdminNotFoundByIdException("failed to find admin"));
	}


	public AdminResponse saveAdmin(AdminRequest adminRequest) {

		Admin admin = adminRepository.save(adminMapper.mapToUser(adminRequest, new Admin()));	
		return adminMapper.mapToUserResponse(admin);
	}


	public AdminResponse updateAdmin(AdminRequest adminRequest, String adminId) {
		return adminRepository.findById(adminId)
				.map(exAdmin -> {
					adminMapper.mapToUser(adminRequest, exAdmin);
					return adminRepository.save(exAdmin);
				})
				.map(adminMapper::mapToUserResponse)
				.orElseThrow(() -> new AdminNotFoundByIdException("Failed to update user"));
	}

}
