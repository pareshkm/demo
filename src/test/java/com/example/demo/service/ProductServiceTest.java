package com.example.demo.service;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.dao.ProductDao;
import com.example.demo.dto.server.ItemServerDto;
import com.example.demo.dto.server.ProductDescriptionServerDto;
import com.example.demo.dto.server.ProductResponseDto;
import com.example.demo.dto.server.ProductServerDto;
import com.example.demo.entity.CurrentPrice;
import com.example.demo.entity.Product;
import com.example.demo.restclient.RestClient;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductService.class, secure = false)
public class ProductServiceTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ProductDao productDao;
	
	@MockBean
	private RestClient restClient;
	
	private Product mockProduct = new Product(13860428L, new CurrentPrice(new BigDecimal(124.56), "USD"));
	
	@Test
	public void getProductById() {
		Mockito.when(productDao.getProductById(Mockito.anyLong())).
			thenReturn(mockProduct);
		
		assertTrue(mockProduct.getId() == 13860428L);
		assertTrue(mockProduct.getCurrent_price().getCurrency_code().equals("USD"));
		assertTrue(mockProduct.getCurrent_price().getValue().equals(new BigDecimal(124.56)));
	}
	
	@Test
	public void getProductNameById() {
		ProductResponseDto mockResponseDto = getMockProductResponseDto();
		Mockito.when(restClient.fetchProductNameById(Mockito.anyLong())).
			thenReturn(mockResponseDto);
		
		assertTrue(mockResponseDto.getProduct().getItem().getProduct_description().getTitle().equals("Mock Product Title"));
	}
		
	private ProductResponseDto getMockProductResponseDto() {
		ProductDescriptionServerDto product_description = new ProductDescriptionServerDto();
		product_description.setTitle("Mock Product Title");
		
		ItemServerDto item = new ItemServerDto();
		item.setProduct_description(product_description);
		
		ProductServerDto productDto = new ProductServerDto();
		productDto.setItem(item);
		
		ProductResponseDto responseDto = new ProductResponseDto();
		responseDto.setProduct(productDto);
		
		return responseDto;
	}

}
