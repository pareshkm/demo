package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;

public interface ProductService {
	public void saveProduct(Product prd); 
	public void saveProducts(List<Product> products);	
	public Product getProductById(long id);
	public String getProductNameById(long id);
}
