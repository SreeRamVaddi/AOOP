package com.product.model;


public class Item {
	private String productName;
	private int quantity;
	private double unitPrice;
	public Item() {
		
	}
	
	
	public Item(String productName, int quantity, double unitPrice) {
		this.productName = productName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	public String toString() {
		String s = this.productName + ":";
		s = s + this.quantity + "\n";
		return s;
	}
	public String getProductName() {
		return this.productName;
	}
	public int getQuantity() {
		return this.quantity;
	}
	public double getUnitPrice() {
		return this.unitPrice;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	
}