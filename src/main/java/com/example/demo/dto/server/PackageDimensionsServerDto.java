package com.example.demo.dto.server;

public class PackageDimensionsServerDto {
//{"weight":"0.18","weight_unit_of_measure":"POUND","width":"5.33","depth":"6.65","height":"0.46","dimension_unit_of_measure":"INCH"}
	private double weight;
	private String weight_unit_of_measure;
	private double width;
	private double depth;
	private double height;
	private String dimension_unit_of_measure;
	
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getWeight_unit_of_measure() {
		return weight_unit_of_measure;
	}
	public void setWeight_unit_of_measure(String weight_unit_of_measure) {
		this.weight_unit_of_measure = weight_unit_of_measure;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getDepth() {
		return depth;
	}
	public void setDepth(double depth) {
		this.depth = depth;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public String getDimension_unit_of_measure() {
		return dimension_unit_of_measure;
	}
	public void setDimension_unit_of_measure(String dimension_unit_of_measure) {
		this.dimension_unit_of_measure = dimension_unit_of_measure;
	}
}
