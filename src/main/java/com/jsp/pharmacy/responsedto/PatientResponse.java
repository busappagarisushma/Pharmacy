package com.jsp.pharmacy.responsedto;

import java.sql.Date;

import com.jsp.pharmacy.enums.Gender;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class PatientResponse {

	private String PatientId;
	private String name;
	private String email;
	private Gender gender;
	private Date date;
	public String getPatientId() {
		return PatientId;
	}
	public void setPatientId(String patientId) {
		PatientId = patientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
