package com.example.demo.dto.server;

public class ItemTypeServerDto {
//"item_type":{"category_type":"Item Type: MMBV","type":300752,"name":"Movies"}
	private String category_type;
	private long type;
	private String name;
	
	public String getCategory_type() {
		return category_type;
	}
	public void setCategory_type(String category_type) {
		this.category_type = category_type;
	}
	public long getType() {
		return type;
	}
	public void setType(long type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
