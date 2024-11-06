package com.jsp.pharmacy.responsedto;

import java.time.LocalDate;

import com.jsp.pharmacy.enums.Form;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class MedicineResponse {

	private String medicineId;
	private String name;
	private String category;
	private String ingredients;
	private int doasageInMg;
	@Enumerated(EnumType.STRING)
	private Form form;
	private String manfucaturer;
	private int stockQuantity;
	private LocalDate expiryDate;
	private Double price;
	
	public String getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(String medicineId) {
		this.medicineId = medicineId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public int getDoasageInMg() {
		return doasageInMg;
	}
	public void setDoasageInMg(int doasageInMg) {
		this.doasageInMg = doasageInMg;
	}
	public Form getForm() {
		return form;
	}
	public void setForm(Form form) {
		this.form = form;
	}
	public String getManfucaturer() {
		return manfucaturer;
	}
	public void setManfucaturer(String manfucaturer) {
		this.manfucaturer = manfucaturer;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
	
}
