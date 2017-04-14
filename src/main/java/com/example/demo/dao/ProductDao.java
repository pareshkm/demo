package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.client.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Component
public class ProductDao {
	
	@Autowired
	private ProductRepository productRepository;
	
	public void saveProduct(Product prd) {
		productRepository.save(prd);
	}
	
	public void saveProducts(List<Product> products) {
		productRepository.save(products);
	}
	
	public Product getProductById(long id) {
		return productRepository.findOne(id);
	}

	public void saveOrUpdateProduct(Product updatedProduct) {
		saveProduct(updatedProduct);
	}
}
