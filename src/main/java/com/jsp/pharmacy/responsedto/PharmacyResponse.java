package com.jsp.pharmacy.responsedto;

public class PharmacyResponse {

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
