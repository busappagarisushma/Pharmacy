package com.jsp.pharmacy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jsp.pharmacy.entity.Admin;
import com.jsp.pharmacy.exception.AdminNotFoundByIdException;
import com.jsp.pharmacy.mapper.AdminMapper;
import com.jsp.pharmacy.repo.AdminRepository;
import com.jsp.pharmacy.requestdto.AdminRequest;
import com.jsp.pharmacy.responsedto.AdminResponse;
import com.jsp.pharmacy.util.AppResponseBuilder;

@Service
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
				.map(adminMapper :: mapToAdminResponse)
				.orElseThrow(() -> new AdminNotFoundByIdException("failed to find admin"));
	}


	public AdminResponse saveAdmin(AdminRequest adminRequest) {

		Admin admin = adminRepository.save(adminMapper.mapToAdmin(adminRequest, new Admin()));	
		return adminMapper.mapToAdminResponse(admin);
	}


	public AdminResponse updateAdmin(AdminRequest adminRequest, String adminId) {
		return adminRepository.findById(adminId)
				.map(exAdmin -> {
					adminMapper.mapToAdmin(adminRequest, exAdmin);
					return adminRepository.save(exAdmin);
				})
				.map(adminMapper::mapToAdminResponse)
				.orElseThrow(() -> new AdminNotFoundByIdException("Failed to update user"));
	}


	public List<AdminResponse> findAllUsers() {
		
		return adminRepository.findAll()
				.stream()
				.map(adminMapper::mapToAdminResponse)
				.toList();
	}

}
