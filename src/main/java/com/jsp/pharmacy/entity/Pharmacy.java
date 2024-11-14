package com.jsp.pharmacy.entity;

import java.util.List;

import com.jsp.pharmacy.config.GenerateCustomId;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Pharmacy {

	@Id
	@GenerateCustomId
	private String pharmacyId;
	private String name;
	private String gstNo;
	private String licenceNo;

	@OneToMany(mappedBy = "pharmacy")
	private List<Patient> patients;


	@OneToMany(mappedBy = "pharmacy")
	private List<Medicine> medicines;

	@OneToOne(mappedBy = "pharmacy")
	private Admin admin;

	@OneToMany(mappedBy = "pharmacy")
	private List<Transaction> transactions;



	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	public List<Medicine> getMedicines() {
		return medicines;
	}
	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}
	public List<Patient> getPatients() {
		return patients;
	}
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public String getPharmacyId() {
		return pharmacyId;
	}
	public void setPharmacyId(String pharmacyId) {
		pharmacyId = pharmacyId;
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
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

}
