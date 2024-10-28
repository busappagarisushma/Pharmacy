package com.jsp.pharmacy.responsedto;

public class AdminResponse {

	private String Id;
	private String name;
	private double gstNo;
	private long licenceNo;
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
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
