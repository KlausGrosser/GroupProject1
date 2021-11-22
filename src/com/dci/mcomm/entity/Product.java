package com.dci.mcomm.entity;

public class Product {

	private int categoryId;
	private int id;
	private String label;
	private String description;
	private double unitPrice;
		
	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}


	@Override
	public String toString() {
		return String.format("(ID: %d) - %s", this.getId(), this.getLabel());
	}
}
