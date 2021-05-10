package com.example.euris.model;

import com.example.euris.util.IMappablePro;

public class Product implements IMappablePro{

	private int id;
	private String product;
	private String price;
	
	public Product() {
		super();
	}

	public Product(int id, String product, String price) {
		super();
		this.id = id;
		this.product = product;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	public int getPound() {
		String[] values = price.split(",");
		return coefficiente(values[0]);
	}
	
	public int getShilling() {
		String[] values = price.split(",");
		return coefficiente(values[1]);
	}
	
	public int getPence() {
		String[] values = price.split(",");
		return coefficiente(values[2]);
	}
	
	public int allToPence() {
		return getPound()*240 + getShilling()*12 + getPence();
	}

	private int coefficiente(String s) {
		return Integer.parseInt(s.substring(0, s.length() - 1));
	}

	static public String allFromPence(int pence) {
		int s = pence / 12;
		int p = pence % 12;
		int P = s / 20;
		s = s % 20;
		return P + "p," + s + "s," + p + "d";
	}
	
	
}
