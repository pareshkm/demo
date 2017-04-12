package com.example.demo.dto.server;

public class ProductServerDto {
	private DeepRedLabelsServerDto deep_red_labels;
	private AvailableToPromiseNetworkServerDto available_to_promise_network;
	private ItemServerDto item;
	
	public DeepRedLabelsServerDto getDeep_red_labels() {
		return deep_red_labels;
	}
	public void setDeep_red_labels(DeepRedLabelsServerDto deep_red_labels) {
		this.deep_red_labels = deep_red_labels;
	}
	public AvailableToPromiseNetworkServerDto getAvailable_to_promise_network() {
		return available_to_promise_network;
	}
	public void setAvailable_to_promise_network(
			AvailableToPromiseNetworkServerDto available_to_promise_network) {
		this.available_to_promise_network = available_to_promise_network;
	}
	public ItemServerDto getItem() {
		return item;
	}
	public void setItem(ItemServerDto item) {
		this.item = item;
	}
}
