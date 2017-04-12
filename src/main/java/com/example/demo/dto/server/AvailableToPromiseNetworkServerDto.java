package com.example.demo.dto.server;

import java.util.Date;

public class AvailableToPromiseNetworkServerDto {

	/*
	 * {"product_id":"13860428","id_type":"TCIN","available_to_promise_quantity":312.0,
	 * "street_date":"2011-11-15T06:00:00.000Z","availability":"AVAILABLE",
	 * "online_available_to_promise_quantity":312.0,"stores_available_to_promise_quantity":0.0,
	 * "availability_status":"IN_STOCK","multichannel_options":["HOLD"]}
	 */
	private long product_id;
	private String id_type;
	private double available_to_promise_quantity;
	private Date street_date;
	private String availability;
	private double online_available_to_promise_quantity;
	private double stores_available_to_promise_quantity;
	private String availability_status;
	private String[] multichannel_options;
	
	public long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}
	public String getId_type() {
		return id_type;
	}
	public void setId_type(String id_type) {
		this.id_type = id_type;
	}
	public double getAvailable_to_promise_quantity() {
		return available_to_promise_quantity;
	}
	public void setAvailable_to_promise_quantity(
			double available_to_promise_quantity) {
		this.available_to_promise_quantity = available_to_promise_quantity;
	}
	public Date getStreet_date() {
		return street_date;
	}
	public void setStreet_date(Date street_date) {
		this.street_date = street_date;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public double getOnline_available_to_promise_quantity() {
		return online_available_to_promise_quantity;
	}
	public void setOnline_available_to_promise_quantity(
			double online_available_to_promise_quantity) {
		this.online_available_to_promise_quantity = online_available_to_promise_quantity;
	}
	public double getStores_available_to_promise_quantity() {
		return stores_available_to_promise_quantity;
	}
	public void setStores_available_to_promise_quantity(
			double stores_available_to_promise_quantity) {
		this.stores_available_to_promise_quantity = stores_available_to_promise_quantity;
	}
	public String getAvailability_status() {
		return availability_status;
	}
	public void setAvailability_status(String availability_status) {
		this.availability_status = availability_status;
	}
	public String[] getMultichannel_options() {
		return multichannel_options;
	}
	public void setMultichannel_options(String[] multichannel_options) {
		this.multichannel_options = multichannel_options;
	}
	
}
