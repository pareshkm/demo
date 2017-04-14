package com.example.demo.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.client.CurrentPriceDto;
import com.example.demo.dto.client.ProductDto;
import com.example.demo.entity.CurrentPrice;
import com.example.demo.entity.Product;
import com.example.demo.exception.ProductError;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
		
	@GetMapping("/products/{id:\\d+}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable long id) {
		Product product = productService.getProductById(id);
		if ( product == null ) {
			throw new ProductNotFoundException(id);
		}
		
		ProductDto productDto = new ProductDto();
		productDto.setId(id);
		
		// Get Product Pricing from Database
		CurrentPrice current_price = product.getCurrent_price();
		BigDecimal value = current_price.getValue();
		String currency_code = current_price.getCurrency_code();
		
		CurrentPriceDto currentPriceDto = new CurrentPriceDto();
		currentPriceDto.setValue(value.setScale(2, RoundingMode.FLOOR));
		currentPriceDto.setCurrency_code(currency_code);		
		productDto.setCurrent_price(currentPriceDto);		
		
		// Get Product Name from REST Call
		String productName = productService.getProductNameById(id);
		productDto.setName(productName);
		
		ResponseEntity<ProductDto> responseEntity = new ResponseEntity<ProductDto>(productDto, HttpStatus.OK);
		
		return responseEntity;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ProductError> productNotFound(ProductNotFoundException e) {
		long id = e.getId();
		ProductError error = new ProductError(4, "Product ID#" + id + " not found");
		return new ResponseEntity<ProductError>(error, HttpStatus.NOT_FOUND);
	}
	
	
	// Create or Update operation
//	@RequestMapping(value="/products/{id:\\d+}", method = RequestMethod.PUT)
//	public void updateProduct(@PathVariable long id, @RequestBody ProductDto updatedProductDto) {
//		if ( updatedProductDto == null || (updatedProductDto.getId() != id) ) {
//			throw new ProductNotFoundException(id);
//		}
//		
//		productService.saveOrUpdateProduct(updatedProductDto);
//	}
	
	
	// Strictly Update
	@RequestMapping(value="/products/{id:\\d+}", method = RequestMethod.PUT)
	public void updateProduct(@PathVariable long id, @RequestBody ProductDto updatedProductDto) {
		if ( updatedProductDto == null || (updatedProductDto.getId() != id) ) {
			throw new ProductNotFoundException(id);
		}
		
		Product product = productService.getProductById(id);
		if ( product == null ) {
			throw new ProductNotFoundException(id);
		}
		
		productService.saveOrUpdateProduct(updatedProductDto);
	}
	
	// TODO: Need to remove after done with my testing
	@GetMapping("/allProducts")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
}
