package com.tka;

public class Product {

	private int ID;
	private String name;
	private int price;
	private int quantity;
	private String category;

	public Product() {
		super();
	}

	public Product(int iD, String name, int price, int quantity, String category) {
		super();
		ID = iD;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	}

	public Product(String name, int price, int quantity, String category) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [ID=" + ID + ", name=" + name + "]";
	}

}
