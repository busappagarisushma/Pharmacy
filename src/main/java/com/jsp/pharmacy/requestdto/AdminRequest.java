package com.jsp.pharmacy.requestdto;

public class AdminRequest {

	private String name;
	private double gstNo;
	private long licenceNo;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getGstNo() {
		return gstNo;
	}
	public void setGstNo(double gstNo) {
		this.gstNo = gstNo;
	}
	public long getLicenceNo() {
		return licenceNo;
	}
	public void setLicenceNo(long licenceNo) {
		this.licenceNo = licenceNo;
	}
	
	
}
