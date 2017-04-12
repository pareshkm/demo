package com.example.demo.exception;

public class ProductNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private long id;
	
	public ProductNotFoundException(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}	

	public void setId(int id) {
		this.id = id;
	}

}
