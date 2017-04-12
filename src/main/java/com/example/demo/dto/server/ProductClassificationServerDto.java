package com.example.demo.dto.server;

public class ProductClassificationServerDto {
//product_type":"542","product_type_name":"ELECTRONICS","item_type_name":"Movies"
	private String product_type;
	private String product_type_name;
	private String item_type_name;
	private ItemTypeServerDto item_type;
	
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	public String getProduct_type_name() {
		return product_type_name;
	}
	public void setProduct_type_name(String product_type_name) {
		this.product_type_name = product_type_name;
	}
	public String getItem_type_name() {
		return item_type_name;
	}
	public void setItem_type_name(String item_type_name) {
		this.item_type_name = item_type_name;
	}
	public ItemTypeServerDto getItem_type() {
		return item_type;
	}
	public void setItem_type(ItemTypeServerDto item_type) {
		this.item_type = item_type;
	}
}
