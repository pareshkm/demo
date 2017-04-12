package com.example.demo.dto.server;

import java.util.Date;

public class AttributesServerDto {
//{"gift_wrapable":"N","has_prop65":"N","is_hazmat":"N","max_order_qty":10,"street_date":"2011-11-15",
//"media_format":"Blu-ray","merch_class":"MOVIES","merch_subclass":34,
	//"return_method":"This item can be returned to any Target store or Target.com."}
	private String gift_wrapable;
	private String has_prop65;
	private String is_hazmat;
	private int max_order_qty;
	private Date street_date;
	private String media_format;
	private String merch_class;
	private int merch_subclass;
	private String return_method;
	
	public String getGift_wrapable() {
		return gift_wrapable;
	}
	public void setGift_wrapable(String gift_wrapable) {
		this.gift_wrapable = gift_wrapable;
	}
	public String getHas_prop65() {
		return has_prop65;
	}
	public void setHas_prop65(String has_prop65) {
		this.has_prop65 = has_prop65;
	}
	public String getIs_hazmat() {
		return is_hazmat;
	}
	public void setIs_hazmat(String is_hazmat) {
		this.is_hazmat = is_hazmat;
	}
	public int getMax_order_qty() {
		return max_order_qty;
	}
	public void setMax_order_qty(int max_order_qty) {
		this.max_order_qty = max_order_qty;
	}
	public Date getStreet_date() {
		return street_date;
	}
	public void setStreet_date(Date street_date) {
		this.street_date = street_date;
	}
	public String getMedia_format() {
		return media_format;
	}
	public void setMedia_format(String media_format) {
		this.media_format = media_format;
	}
	public String getMerch_class() {
		return merch_class;
	}
	public void setMerch_class(String merch_class) {
		this.merch_class = merch_class;
	}
	public int getMerch_subclass() {
		return merch_subclass;
	}
	public void setMerch_subclass(int merch_subclass) {
		this.merch_subclass = merch_subclass;
	}
	public String getReturn_method() {
		return return_method;
	}
	public void setReturn_method(String return_method) {
		this.return_method = return_method;
	}
}
