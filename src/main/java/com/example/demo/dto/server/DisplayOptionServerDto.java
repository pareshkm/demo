package com.example.demo.dto.server;

public class DisplayOptionServerDto {
//{"is_size_chart":false,"is_warranty":false}
	private boolean is_size_chart;
	private boolean is_warranty;
	
	public boolean isIs_size_chart() {
		return is_size_chart;
	}
	public void setIs_size_chart(boolean is_size_chart) {
		this.is_size_chart = is_size_chart;
	}
	public boolean isIs_warranty() {
		return is_warranty;
	}
	public void setIs_warranty(boolean is_warranty) {
		this.is_warranty = is_warranty;
	}
}
