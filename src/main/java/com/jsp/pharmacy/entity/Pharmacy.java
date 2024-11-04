package com.jsp.pharmacy.entity;

import com.jsp.pharmacy.config.GenerateCustomId;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pharmacy {

	@Id
	@GenerateCustomId
	private String PharmacyId;
	private String name;
	private String gstNo;
	private String licenceNo;
	
	
	public String getPharmacyId() {
		return PharmacyId;
	}
	public void setPharmacyId(String pharmacyId) {
		PharmacyId = pharmacyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
	public String getLicenceNo() {
		return licenceNo;
	}
	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}
	
	
	
}
