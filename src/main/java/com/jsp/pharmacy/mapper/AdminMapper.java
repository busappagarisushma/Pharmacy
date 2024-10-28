package com.jsp.pharmacy.mapper;

import org.springframework.stereotype.Component;

import com.jsp.pharmacy.entity.Admin;
import com.jsp.pharmacy.requestdto.AdminRequest;
import com.jsp.pharmacy.responsedto.AdminResponse;

@Component
public class AdminMapper {

	public Admin mapToAdmin(AdminRequest request,Admin admin) {

		admin.setName(request.getName());
		admin.setLicenceNo(request.getLicenceNo());;
		admin.setGstNo(request.getGstNo());

		return admin;
	}

	public AdminResponse mapToAdminResponse(Admin admin) {

		AdminResponse response = new AdminResponse();
		
		response.setId(admin.getId());
		response.setName(admin.getName());
		response.setLicenceNo(admin.getLicenceNo());
		response.setGstNo(admin.getGstNo());

		return response;
	}
}
