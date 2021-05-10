package com.example.euris.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.example.euris.model.Product;
import com.example.euris.util.BasicDao;

@Repository
public class DaoProductsMySQL extends BasicDao implements IDaoProducts {

	public DaoProductsMySQL(@Value("${db.address}") String dbAddress, @Value("${db.user}") String user,
			@Value("${db.psw}") String password) {
		super(dbAddress, user, password);
	}

	@Override
	public List<Product> products() {
		List<Product> ris = new ArrayList<>();

		List<Map<String, String>> maps = getAll("SELECT * FROM products");

		for (Map<String, String> map : maps) {
			Product p = new Product();
			p.fromMap(map);
			ris.add(p);
		}

		return ris;
	}

	@Override
	public Product products(int id) {
		Product ris = null;

		Map<String, String> map = getOne("SELECT * FROM prodotti WHERE id = ?", id);

		if (map != null) {
			ris = new Product();
			ris.fromMap(map);
		}

		return ris;
	}

	@Override
	public void add(Product p) {
		execute("INSERT INTO prodotti (product, price) VALUES (?, ?)", p.getProduct(), p.getPrice());
	}

	@Override
	public void delete(int id) {
		execute("DELETE FROM products WHERE id = ?", id);
	}

	@Override
	public void update(Product p) {
		execute("UPDATE products SET product = ?, price = ?", p.getProduct(), p.getPrice());
	}

	@Override
	public String sum(Product product1, Product product2) {
			
			int sum = product1.allToPence() + product2.allToPence();
			
			return Product.allFromPence(sum);
	}
	
	@Override
	public String multi(Product product1, int factor) {

			int multi = product1.allToPence()*factor;
			
			return Product.allFromPence(multi);	
	}

	@Override
	public String div(Product product1, int divider) {
			
			int div = product1.allToPence() / divider;
			int remainder = product1.allToPence() % divider;
		return Product.allFromPence(div) + "(" + Product.allFromPence(remainder) + ")";
	}

}
