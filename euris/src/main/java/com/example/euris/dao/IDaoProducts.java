package com.example.euris.dao;

import java.util.List;

import com.example.euris.model.Product;

public interface IDaoProducts {

	List<Product> products();
	
	Product products(int id);
	
	void add(Product p);
	
	void delete(int id);
	
	void update(Product p);
	
	public String sum(Product product1, Product product2);
	
	public String multi(Product product1, int factor);
	
	public String div(Product product1, int divider);
}
