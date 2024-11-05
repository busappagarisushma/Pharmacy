package com.jsp.pharmacy.entity;

import java.util.List;

import com.jsp.pharmacy.config.GenerateCustomId;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Pharmacy {

	@Id
	@GenerateCustomId
	private String PharmacyId;
	private String name;
	private String gstNo;
	private String licenceNo;
	
	@OneToMany(mappedBy = "pharmacy")
	private List<Patient> patients;
	
	
	public List<Patient> getPatients() {
		return patients;
	}
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	
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
