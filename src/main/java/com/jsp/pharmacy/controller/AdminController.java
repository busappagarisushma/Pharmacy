package com.jsp.pharmacy.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.pharmacy.requestdto.AdminRequest;
import com.jsp.pharmacy.responsedto.AdminResponse;
import com.jsp.pharmacy.service.AdminService;
import com.jsp.pharmacy.util.AppResponseBuilder;
import com.jsp.pharmacy.util.ResponseStructure;

@RestController
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

	@PostMapping("/admins")
	public ResponseEntity<ResponseStructure<AdminResponse>> saveAdmin(@RequestBody AdminRequest adminRequest){
		AdminResponse response = adminService.saveAdmin(adminRequest);
		return appResponseBuilder.success(HttpStatus.CREATED, "user created", response);
	}

	@PutMapping("/admins/{adminId}")
	public ResponseEntity<ResponseStructure<AdminResponse>> updateAdmin(@RequestBody AdminRequest adminRequest,@PathVariable String adminId){
		AdminResponse response = adminService.updateAdmin(adminRequest,adminId);
		return appResponseBuilder.success(HttpStatus.OK, "admin Updated", response);
	}

	@GetMapping("/admins")
	public ResponseEntity<ResponseStructure<List<AdminResponse>>> findAllAdmins(){
		List<AdminResponse> responses = adminService.findAllUsers();
		return appResponseBuilder.success(HttpStatus.FOUND,"users found",responses);
	}
	
}
