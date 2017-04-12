package com.example.demo.dto.client;

public class ProductDto {
	
	private long id;
	private String name;
	private CurrentPriceDto current_price;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CurrentPriceDto getCurrent_price() {
		return current_price;
	}
	public void setCurrent_price(CurrentPriceDto current_price) {
		this.current_price = current_price;
	}

}
