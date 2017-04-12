package com.example.demo.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.client.CurrentPriceDto;
import com.example.demo.dto.client.ProductDto;
import com.example.demo.entity.CurrentPrice;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
		
	@GetMapping("/products/{id:\\d+}")
	public ProductDto getProductById(@PathVariable long id) {
		ProductDto productDto = new ProductDto();
		productDto.setId(id);
		
		// Get Product Pricing from Database
		Product product = productService.getProductById(id);
		CurrentPrice current_price = product.getCurrent_price();
		BigDecimal value = current_price.getValue();
		String currency_code = current_price.getCurrency_code();
		
		CurrentPriceDto currentPriceDto = new CurrentPriceDto();
		currentPriceDto.setValue(value);
		currentPriceDto.setCurrency_code(currency_code);		
		productDto.setCurrent_price(currentPriceDto);		
		
		// Get Product Name from REST Call
		String productName = productService.getProductNameById(id);
		productDto.setName(productName);
		
		return productDto;
	}
}
