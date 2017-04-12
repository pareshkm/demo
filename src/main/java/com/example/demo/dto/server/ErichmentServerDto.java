package com.example.demo.dto.server;

public class ErichmentServerDto {
	private ImageServerDto[] images;
	private SalesClassificationNodeServerDto[] sales_classification_nodes;
	
	public ImageServerDto[] getImages() {
		return images;
	}
	public void setImages(ImageServerDto[] images) {
		this.images = images;
	}
	public SalesClassificationNodeServerDto[] getSales_classification_nodes() {
		return sales_classification_nodes;
	}
	public void setSales_classification_nodes(
			SalesClassificationNodeServerDto[] sales_classification_nodes) {
		this.sales_classification_nodes = sales_classification_nodes;
	}
}
