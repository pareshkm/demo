package com.example.demo.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	private long id;
	
	@AttributeOverrides ({
		@AttributeOverride(name="value", column=@Column(name="value")),
		@AttributeOverride(name="currency_code", column=@Column(name="currency_code"))
	})
	@Embedded
	private CurrentPrice current_price;
	
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
