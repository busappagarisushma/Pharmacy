package com.jsp.pharmacy.mapper;

import org.springframework.stereotype.Component;

import com.jsp.pharmacy.entity.Pharmacy;
import com.jsp.pharmacy.requestdto.PharmacyRequest;
import com.jsp.pharmacy.responsedto.PharmacyResponse;

@Component
public class PharmacyMapper {

	public Pharmacy mapToPharmacy(PharmacyRequest request,Pharmacy pharmacy) {
		
		pharmacy.setName(request.getName());
		pharmacy.setGstNo(request.getGstNo());
		pharmacy.setLicenceNo(request.getLicenceNo());
		
		return pharmacy;
	}
	
	public PharmacyResponse mapToPharmacyResponse(Pharmacy pharmacy) {
		
		PharmacyResponse response = new PharmacyResponse();
		
		response.setPharmacyId(pharmacy.getPharmacyId());
		response.setName(pharmacy.getName());
		response.setLicenceNo(pharmacy.getLicenceNo());
		response.setGstNo(pharmacy.getGstNo());
		
		return response;
	}
}
