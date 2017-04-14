package com.example.demo.entity;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class CurrentPrice {
	private BigDecimal value;	
	private String currency_code;
	
	public CurrentPrice(BigDecimal value, String currency_code) {
		super();
		this.value = value;
		this.currency_code = currency_code;
	}
	
	public CurrentPrice() {
		
	}
	
	public String getCurrency_code() {
		return currency_code;
	}
	public void setCurrency_code(String currency_code) {
		this.currency_code = currency_code;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
}
