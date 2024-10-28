package com.jsp.pharmacy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jsp.pharmacy.responsedto.AdminResponse;
import com.jsp.pharmacy.service.AdminService;
import com.jsp.pharmacy.util.AppResponseBuilder;
import com.jsp.pharmacy.util.ResponseStructure;

public class AdminController {

	private final AdminService adminService;
	private final AppResponseBuilder appResponseBuilder;

	public AdminController(AdminService adminService,AppResponseBuilder appResponseBuilder) {
		super();
		this.adminService = adminService;
		this.appResponseBuilder = appResponseBuilder;
	}
	
	@GetMapping("admins/{adminId}")
	public ResponseEntity<ResponseStructure<AdminResponse>> findByAdminId(@PathVariable String  adminId){
		AdminResponse response = adminService.findByAdminId(adminId);
		return appResponseBuilder.success(HttpStatus.FOUND, "user found",response);
	}
	
}
