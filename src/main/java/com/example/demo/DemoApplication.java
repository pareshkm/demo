package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.CurrencyCode;
import com.example.demo.entity.CurrentPrice;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@SpringBootApplication
public class DemoApplication {
	
	@Autowired
	private ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@PostConstruct
	public void loadProductData() {
		List<Product> products = new ArrayList<Product>();
		
		Product prd1 = new Product();
		prd1.setId(13860428);
		CurrentPrice cp1 = new CurrentPrice();
		cp1.setValue(new BigDecimal(100.53));
		cp1.setCurrency_code(CurrencyCode.USD.name());
		prd1.setCurrent_price(cp1);
		products.add(prd1);
		
		Product prd2 = new Product();
		prd2.setId(1383242);
		CurrentPrice cp2 = new CurrentPrice();
		cp2.setValue(new BigDecimal(360.57));
		cp2.setCurrency_code(CurrencyCode.DNR.name());
		prd2.setCurrent_price(cp2);
		products.add(prd2);
		
		Product prd3 = new Product();
		prd3.setId(532727);
		CurrentPrice cp3 = new CurrentPrice();
		cp3.setValue(new BigDecimal(1476.68));
		cp3.setCurrency_code(CurrencyCode.INR.name());
		prd3.setCurrent_price(cp3);
		products.add(prd3);
		
		productService.saveProducts(products);
	}
}
