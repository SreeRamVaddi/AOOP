package com.product.shopping;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.product.model.Item;
public class ShoppingCart {
	List<Item> items;
	double totalAmount;
	double payableAmount;
	double discount;
	double tax;
	String coupon;
public	ShoppingCart() {
		this.items = new ArrayList<Item>();
		this.coupon = "";
		this.totalAmount = 0;
		this.payableAmount = 0;
		this.discount = 0;
		this.tax = 0;
	}
	public void addToCart(Item item) {
		this.items.add(item);
	}
	public void showCart() {
		ListIterator<Item> iterator = items.listIterator();
		while(iterator.hasNext()) {
			Item item1 = iterator.next();
			System.out.println(item1);
		}
	}
	public void removeFromCart(Item i) {
		ListIterator<Item> iterator1 = items.listIterator();
		while(iterator1.hasNext()) {
			Item item2 = iterator1.next();
			if (item2.getProductName().equals(i.getProductName())) {
				this.items.remove(i);
				break;
			}
		}
	}
	public double getTotalAmount() {
		ListIterator<Item> iterator2 = items.listIterator();
		this.totalAmount = 0;
		while(iterator2.hasNext()) {
			Item item3 = iterator2.next();
			this.totalAmount = this.totalAmount + (item3.getUnitPrice() * item3.getQuantity());
		}
		return this.totalAmount;
	}
	public void applyCoupon(String coupon) {
		this.coupon = coupon;
		if (coupon.equals("IND10")) {
			this.discount = this.getTotalAmount() * (0.1);
			this.totalAmount = this.totalAmount - this.discount;
		} else {
			this.totalAmount = this.totalAmount;
		}
	}
	public double getPayableAmount() {
		this.payableAmount = 0;
		this.tax = this.totalAmount * (0.14);
		this.payableAmount = this.totalAmount + this.tax;
		return this.payableAmount;
	}
	public void printInvoice() {
		ListIterator<Item> iterator3 = items.listIterator();
		while(iterator3.hasNext()) {
			Item item4 = iterator3.next();
			System.out.print(item4.getProductName() + "\t");
			System.out.print(item4.getQuantity() + "\t");
			System.out.print(item4.getUnitPrice() + "\t");
			System.out.println(item4.getUnitPrice() * item4.getQuantity());
		}
		System.out.println("\t\t\t" + "Total    : " + this.getTotalAmount());
		this.applyCoupon(this.coupon);
		System.out.println("\t\t\t" + "Discount : " + this.discount);
		this.getPayableAmount();
		System.out.println("\t\t\t" + "Tax      : " + this.tax);
		System.out.println("\t\t\t" + "Total    : " + this.getPayableAmount());
	}
	
	public List<Item> getItems() {
		
		return items;
	}
}