package com.jsp.pharmacy.entity;

import java.time.LocalDate;

import com.jsp.pharmacy.config.GenerateCustomId;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {

	@Id
	@GenerateCustomId
	private String transactionId;
	private LocalDate dateTime;
	private int quantity;

	@ManyToOne
	private Pharmacy pharmacy;

	@ManyToOne
	private Medicine medicine;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public LocalDate getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDate dateTime) {
		this.dateTime = dateTime;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	
}
