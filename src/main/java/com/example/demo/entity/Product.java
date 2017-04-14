package com.example.demo.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	private long id;
	
	@Embedded
	private CurrentPrice current_price;
	
	public Product(long id, CurrentPrice current_price) {
		super();
		this.id = id;
		this.current_price = current_price;
	}
	
	public Product() {
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public CurrentPrice getCurrent_price() {
		return current_price;
	}
	public void setCurrent_price(CurrentPrice current_price) {
		this.current_price = current_price;
	}

}
