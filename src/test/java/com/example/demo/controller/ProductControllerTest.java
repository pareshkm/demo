package com.example.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.entity.CurrentPrice;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductController.class, secure = false)
public class ProductControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService productService;
		
	private Product mockProduct = new Product(13860428L, new CurrentPrice(new BigDecimal(124.56), "USD"));
	private Product nullProduct = null;
	private String mockProductName = "55 inch TV";
	private long mockExistingProductId = 13860428;
	private long mockNonExistingProductId = 9999999;
	private String jsonResponseString = "{\"id\":"+mockExistingProductId+",\"name\":\"" + mockProductName + "\","
			+ "\"current_price\":{\"value\":124.56,\"currency_code\":\"USD\"}}";
	private String expectedErrorMessage = "{\"code\":4,\"message\":\"Product ID#"+mockNonExistingProductId+" not found\"}";
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void getProductByIdHappyPath() throws Exception {
		Mockito.when(productService.getProductById(Mockito.anyLong())).
				thenReturn(mockProduct);
		
		Mockito.when(productService.getProductNameById(Mockito.anyLong())).
				thenReturn(mockProductName);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/products/{id}", mockExistingProductId).accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(HttpStatus.valueOf(result.getResponse().getStatus()), HttpStatus.OK);
						
		JSONAssert.assertEquals(jsonResponseString, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	public void getProductByIdNonExistantProductId() throws Exception {			    
		Mockito.when(productService.getProductById(Mockito.anyLong())).
				thenReturn(nullProduct);
		
		Mockito.when(productService.getProductNameById(Mockito.anyLong())).
				thenReturn(mockProductName);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/products/{id}", mockNonExistingProductId).accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertTrue(result.getResolvedException().getClass().getName().contains("ProductNotFoundException"));
		result.getResolvedException().getClass().getName();
		assertEquals(result.getResponse().getContentAsString(), expectedErrorMessage);
		assertEquals(HttpStatus.valueOf(result.getResponse().getStatus()), HttpStatus.NOT_FOUND);
	}
	
	@Test
	public void updateProductHappyPath() throws Exception {		
		Mockito.when(productService.getProductById(Mockito.anyLong())).
				thenReturn(mockProduct);
				
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.put("/products/{id}", mockExistingProductId)
				.accept(MediaType.APPLICATION_JSON).content(jsonResponseString)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(HttpStatus.valueOf(result.getResponse().getStatus()), HttpStatus.OK);
	}
	
	@Test
	public void updateProductNonExistantProductId() throws Exception {		
		Mockito.when(productService.getProductById(Mockito.anyLong())).
				thenReturn(nullProduct);
				
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.put("/products/{id}", 9999999)
				.accept(MediaType.APPLICATION_JSON).content(jsonResponseString)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertTrue(result.getResolvedException().getClass().getName().contains("ProductNotFoundException"));
		result.getResolvedException().getClass().getName();
		assertEquals(result.getResponse().getContentAsString(), expectedErrorMessage);
		assertEquals(HttpStatus.valueOf(result.getResponse().getStatus()), HttpStatus.NOT_FOUND);
	}
	
	@Test
	public void updateProductMismatchedId() throws Exception {		
		Mockito.when(productService.getProductById(Mockito.anyLong())).
				thenReturn(mockProduct);
				
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.put("/products/{id}", 42434242)
				.accept(MediaType.APPLICATION_JSON).content(jsonResponseString)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertTrue(result.getResolvedException().getClass().getName().contains("ProductNotFoundException"));
		result.getResolvedException().getClass().getName();
		String expectedErrorMessage = "{\"code\":4,\"message\":\"Product ID#42434242 not found\"}";
		assertEquals(result.getResponse().getContentAsString(), expectedErrorMessage);
		assertEquals(HttpStatus.valueOf(result.getResponse().getStatus()), HttpStatus.NOT_FOUND);
	}
}
