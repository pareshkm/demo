package com.example.demo.service;

import java.math.RoundingMode;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductDao;
import com.example.demo.dto.client.CurrentPriceDto;
import com.example.demo.dto.client.ProductDto;
import com.example.demo.dto.server.ItemServerDto;
import com.example.demo.dto.server.ProductDescriptionServerDto;
import com.example.demo.dto.server.ProductResponseDto;
import com.example.demo.dto.server.ProductServerDto;
import com.example.demo.entity.CurrentPrice;
import com.example.demo.entity.Product;
import com.example.demo.restclient.RestClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private RestClient restClient;

	@Override
	public void saveProducts(List<Product> products) {
		productDao.saveProducts(products);
	}

	@Cacheable(value="productsCache", key="#id")
	@Override
	public Product getProductById(long id) {
		return productDao.getProductById(id);
	}
	
//	@HystrixCommand(fallbackMethod = "defaultTitle")
//	@Override
//	public String getProductNameById(long id) {
//		String title = "Unavailable";
//		ProductResponseDto responseDto = restClient.fetchProductNameById(id);
//		if ( responseDto != null ) {
//			ProductServerDto productDto = responseDto.getProduct();
//			if ( productDto != null ) {
//				ItemServerDto item = productDto.getItem();
//				if ( item != null ) {
//					ProductDescriptionServerDto product_description = item.getProduct_description();
//					if ( product_description != null ) {
//						title = product_description.getTitle();
//					}
//				}
//			}
//		}
//		return title;
//	}
	
	@HystrixCommand(fallbackMethod = "defaultTitle")
	@Override
	public String getProductNameById(long id) {
		String title = "Unavailable";
		CompletableFuture<ProductResponseDto> futureResponse = CompletableFuture.supplyAsync(() -> restClient.fetchProductNameById(id));
		ProductResponseDto responseDto = null;
		try {
			responseDto = futureResponse.get(2000, TimeUnit.MILLISECONDS);
		} catch (Exception e) {
			title = "Product Name Unavailable";
			e.printStackTrace();
		}
		if ( responseDto != null ) {
			ProductServerDto productDto = responseDto.getProduct();
			if ( productDto != null ) {
				ItemServerDto item = productDto.getItem();
				if ( item != null ) {
					ProductDescriptionServerDto product_description = item.getProduct_description();
					if ( product_description != null ) {
						title = product_description.getTitle();
					}
				}
			}
		}
		return title;
	}
	
	public String defaultTitle(long id) {
	    return "Product Name Unavailable Temporarily";
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
	
}
