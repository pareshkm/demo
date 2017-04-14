package com.example.demo.service;

import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Override
	public Product getProductById(long id) {
		return productDao.getProductById(id);
	}
		
	@Override
	public String getProductNameById(long id) {
		String title = "Unavailable";
		ProductResponseDto responseDto = restClient.fetchProductNameById(id);
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
