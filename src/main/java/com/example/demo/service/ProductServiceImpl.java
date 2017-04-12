package com.example.demo.service;

import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductDao;
import com.example.demo.dto.client.CurrentPriceDto;
import com.example.demo.dto.client.ProductDto;
import com.example.demo.dto.server.ProductServerDto;
import com.example.demo.entity.CurrentPrice;
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
		return "Mock Product Name";
	}
	
	@Override
	public void saveOrUpdateProduct(ProductDto updatedProductDto) {
		Product updatedProduct = new Product();
		updatedProduct.setId(updatedProductDto.getId());
		
		CurrentPriceDto currentPriceDto = updatedProductDto.getCurrent_price();
		CurrentPrice current_price = new CurrentPrice();
		current_price.setCurrency_code(currentPriceDto.getCurrency_code());
		current_price.setValue(currentPriceDto.getValue().setScale(2, RoundingMode.FLOOR));
		updatedProduct.setCurrent_price(current_price);
		
		productDao.saveOrUpdateProduct(updatedProduct);
	}
	
	@Override
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}
}
