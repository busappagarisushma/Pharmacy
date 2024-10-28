package com.jsp.pharmacy.entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

@Entity
public class Admin {

	@GeneratedValue()
	@Id
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
