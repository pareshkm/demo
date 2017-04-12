package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductDao;
import com.example.demo.dto.server.ProductServerDto;
import com.example.demo.entity.Product;
import com.example.demo.restclient.RestClient;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private RestClient restClient;

	@Override
	public void saveProduct(Product prd) {
		productDao.saveProduct(prd);
	}

	@Override
	public void saveProducts(List<Product> products) {
		productDao.saveProducts(products);
	}

	@Override
	public Product getProductById(long id) {
		return productDao.getProductById(id);
	}
		
	@Override
	public String getProductNameById(long id) {
		ProductServerDto productDto = restClient.fetchProductNameById(id);
		// Retrieve product name from productDto and return
		return "MockProductName";
	}
}
