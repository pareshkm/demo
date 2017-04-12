package com.example.demo.dto.server;

public class TaxCategoryServerDto {
//{"tax_class":"G","tax_code_id":99999,"tax_code":"99999"}
	private String tax_class;
	private long tax_code_id;
	private String tax_code;
	
	public String getTax_class() {
		return tax_class;
	}
	public void setTax_class(String tax_class) {
		this.tax_class = tax_class;
	}
	public long getTax_code_id() {
		return tax_code_id;
	}
	public void setTax_code_id(long tax_code_id) {
		this.tax_code_id = tax_code_id;
	}
	public String getTax_code() {
		return tax_code;
	}
	public void setTax_code(String tax_code) {
		this.tax_code = tax_code;
	}
}
