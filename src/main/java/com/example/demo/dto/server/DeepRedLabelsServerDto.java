package com.example.demo.dto.server;

public class DeepRedLabelsServerDto {
	private int total_count;
	private LabelServerDto[] labels;
	
	public int getTotal_count() {
		return total_count;
	}
	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}
	public LabelServerDto[] getLabels() {
		return labels;
	}
	public void setLabels(LabelServerDto[] labels) {
		this.labels = labels;
	}
}
