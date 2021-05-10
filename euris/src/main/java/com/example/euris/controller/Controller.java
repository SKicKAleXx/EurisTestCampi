package com.example.euris.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.euris.dao.IDaoProducts;
import com.example.euris.model.Product;



@RestController
@RequestMapping("/products")
public class Controller {
	@Autowired
	private IDaoProducts dao;
	
	@GetMapping()
	public List<Product> get(){
		return dao.products();
	}
	
	@GetMapping("/{id}")
	public Product get(@PathVariable int id) {
		return dao.products(id);
	}
	
	@PostMapping
	public void add(@RequestBody Product product) {
		dao.add(product);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		dao.delete(id);
	}
	
	@PutMapping
	public void update(@RequestBody Product product) {
		dao.update(product);
	}

    @GetMapping("/sum/{id1}/{id2}")
    public String sum (@PathVariable int id1, @PathVariable int id2) {
    	return dao.sum(dao.products(id1), dao.products(id2));
    }
    
    @GetMapping("/multi/{id}/{a}")
	public String multi (@PathVariable int id, @PathVariable int a) {
		return dao.multi(dao.products(id), a);	
	}
	
	@GetMapping("/div/{id}/{a}")
	public String div (@PathVariable int id, @PathVariable int a) {
		return dao.div(dao.products(id), a);
	}
    
}
