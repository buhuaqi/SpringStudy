package com.spring.beans.cycle;

public class Car {
	private String brand;
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
		System.out.println("setBrand..");
	}

	public Car(){
		System.out.println("Car's Constructor");
	}
	
	public void init2() {
		System.out.println("init..");
	}
	
	public void destroy2() {
		System.out.println("destroy..");
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + "]";
	}
	
}
