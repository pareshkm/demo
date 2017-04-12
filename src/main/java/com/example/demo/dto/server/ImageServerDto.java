package com.example.demo.dto.server;

public class ImageServerDto {
//{"base_url":"http://target.scene7.com/is/image/Target/","primary":"13860428"
	private String base_url;
	private String primary;
	
	public String getBase_url() {
		return base_url;
	}
	public void setBase_url(String base_url) {
		this.base_url = base_url;
	}
	public String getPrimary() {
		return primary;
	}
	public void setPrimary(String primary) {
		this.primary = primary;
	}
}
