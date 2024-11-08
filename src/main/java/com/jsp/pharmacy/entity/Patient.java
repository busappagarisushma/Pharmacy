package com.jsp.pharmacy.entity;

import java.sql.Date;

import com.jsp.pharmacy.config.GenerateCustomId;
import com.jsp.pharmacy.enums.Gender;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Patient {

	@Id
	@GenerateCustomId
	private String patientId;
	private String name;
	private String phoneNumber;
	private String email;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private Date date;

	@ManyToOne
	private Pharmacy pharmacy;
	
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		patientId = patientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Pharmacy getPharmacy() {
		return pharmacy;
	}
	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}


}
