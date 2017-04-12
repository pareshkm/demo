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
		
		Product product1 = new Product();
		product1.setId(13860428);
		CurrentPrice currentPrice1 = new CurrentPrice();
		currentPrice1.setValue(new BigDecimal(100.53));
		currentPrice1.setCurrency_code(CurrencyCode.USD.name());
		product1.setCurrent_price(currentPrice1);
		products.add(product1);
		
		Product product2 = new Product();
		product2.setId(15117729);
		CurrentPrice currentPrice2 = new CurrentPrice();
		currentPrice2.setValue(new BigDecimal(360.57));
		currentPrice2.setCurrency_code(CurrencyCode.DNR.name());
		product2.setCurrent_price(currentPrice2);
		products.add(product2);
		
		Product product3 = new Product();
		product3.setId(16483589);
		CurrentPrice currentPrice3 = new CurrentPrice();
		currentPrice3.setValue(new BigDecimal(1476.68));
		currentPrice3.setCurrency_code(CurrencyCode.INR.name());
		product3.setCurrent_price(currentPrice3);
		products.add(product3);
		
		Product product4 = new Product();
		product4.setId(16696652);
		CurrentPrice currentPrice4 = new CurrentPrice();
		currentPrice4.setValue(new BigDecimal(960.57));
		currentPrice4.setCurrency_code(CurrencyCode.USD.name());
		product4.setCurrent_price(currentPrice4);
		products.add(product4);
		
		Product product5 = new Product();
		product5.setId(16752456);
		CurrentPrice currentPrice5 = new CurrentPrice();
		currentPrice5.setValue(new BigDecimal(1116.68));
		currentPrice5.setCurrency_code(CurrencyCode.USD.name());
		product5.setCurrent_price(currentPrice5);
		products.add(product5);
		
		Product product6 = new Product();
		product6.setId(15643793);
		CurrentPrice currentPrice6 = new CurrentPrice();
		currentPrice6.setValue(new BigDecimal(210.27));
		currentPrice6.setCurrency_code(CurrencyCode.INR.name());
		product6.setCurrent_price(currentPrice6);
		products.add(product6);
				
		productService.saveProducts(products);
	}
}
