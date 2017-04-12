package com.example.demo.exception;

public class ProductError {
	
	private int code;
	private String message;
	
	public ProductError(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public int getCode() {
	
		return code;
	}
	
	public String getMessage() {	
		return message;
	}
}