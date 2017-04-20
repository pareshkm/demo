package com.example.demo.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class CurrentPrice implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
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
