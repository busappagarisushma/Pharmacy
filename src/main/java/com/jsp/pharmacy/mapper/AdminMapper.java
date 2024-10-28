package com.jsp.pharmacy.mapper;

import org.springframework.stereotype.Component;

import com.jsp.pharmacy.entity.Admin;
import com.jsp.pharmacy.requestdto.AdminRequest;
import com.jsp.pharmacy.responsedto.AdminResponse;

@Component
public class AdminMapper {

	public Admin mapToUser(AdminRequest request,Admin admin) {

		admin.setName(request.getName());
		admin.setLicenceNo(request.getLicenceNo());;
		admin.setGstNo(request.getGstNo());

		return admin;
	}

	public AdminResponse mapToUserResponse(Admin user) {

		AdminResponse response = new AdminResponse();
		response.setId(response.getId());
		response.setName(response.getName());
		response.setLicenceNo(response.getLicenceNo());
		response.setGstNo(response.getGstNo());

		return response;
	}
}
