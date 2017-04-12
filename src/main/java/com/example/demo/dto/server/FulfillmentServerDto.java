package com.example.demo.dto.server;

public class FulfillmentServerDto {
//{"is_po_box_prohibited":true,"po_box_prohibited_message":"We regret that this item cannot be shipped to PO Boxes."}
	private boolean is_po_box_prohibited;
	private String po_box_prohibited_message;
	
	public boolean isIs_po_box_prohibited() {
		return is_po_box_prohibited;
	}
	public void setIs_po_box_prohibited(boolean is_po_box_prohibited) {
		this.is_po_box_prohibited = is_po_box_prohibited;
	}
	public String getPo_box_prohibited_message() {
		return po_box_prohibited_message;
	}
	public void setPo_box_prohibited_message(String po_box_prohibited_message) {
		this.po_box_prohibited_message = po_box_prohibited_message;
	}
}
