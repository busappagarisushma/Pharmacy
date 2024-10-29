package com.jsp.pharmacy.mapper;

import org.springframework.stereotype.Component;

import com.jsp.pharmacy.entity.Admin;
import com.jsp.pharmacy.requestdto.AdminRequest;
import com.jsp.pharmacy.responsedto.AdminResponse;

@Component
public class AdminMapper {

	public Admin mapToAdmin(AdminRequest request,Admin admin) {

		admin.setEmail(request.getEmail());
		admin.setPassword(request.getPassword());;
		admin.setPhoneNUmber(request.getPhoneNumber());

		return admin;
	}

	public AdminResponse mapToAdminResponse(Admin admin) {

		AdminResponse response = new AdminResponse();
		
		response.setAdminId(admin.getAdminId());
		response.setEmail(admin.getEmail());

		return response;
	}
}
