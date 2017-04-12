package com.example.demo.dto.server;

public class BundleComponentsServerDto {
	// "is_assortment":false,"is_kit_master":false
	private boolean is_assortment;
	private boolean is_kit_master;
	
	public boolean isIs_assortment() {
		return is_assortment;
	}
	public void setIs_assortment(boolean is_assortment) {
		this.is_assortment = is_assortment;
	}
	public boolean isIs_kit_master() {
		return is_kit_master;
	}
	public void setIs_kit_master(boolean is_kit_master) {
		this.is_kit_master = is_kit_master;
	}
}
