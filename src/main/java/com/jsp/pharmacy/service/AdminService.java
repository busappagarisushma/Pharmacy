package com.jsp.pharmacy.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jsp.pharmacy.entity.Admin;
import com.jsp.pharmacy.exception.AdminNotFoundByIdException;
import com.jsp.pharmacy.mapper.AdminMapper;
import com.jsp.pharmacy.repo.AdminRepository;
import com.jsp.pharmacy.requestdto.AdminRequest;
import com.jsp.pharmacy.responsedto.AdminResponse;

@Service
public class AdminService {

	private final AdminRepository adminRepository;
	private final AdminMapper adminMapper;
	private final PasswordEncoder passwordEncoder;
	
	public AdminService(AdminRepository adminRepository, AdminMapper adminMapper,
			PasswordEncoder passwordEncoder) {
		super();
		this.adminRepository = adminRepository;
		this.adminMapper = adminMapper;
		this.passwordEncoder = passwordEncoder;
	}


	public AdminResponse findByAdminId(String  adminId) {

		return adminRepository.findById(adminId)
				.map(adminMapper :: mapToAdminResponse)
				.orElseThrow(() -> new AdminNotFoundByIdException("failed to find admin"));
	}


	public AdminResponse saveAdmin(AdminRequest adminRequest) {

		Admin admin = adminMapper.mapToAdmin(adminRequest, new Admin());
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		adminRepository.save(admin);
		return  adminMapper.mapToAdminResponse(admin);
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


	public List<AdminResponse> findAllAdmins() {
		
		return adminRepository.findAll()
				.stream()
				.map(adminMapper::mapToAdminResponse)
				.toList();
	}

}
