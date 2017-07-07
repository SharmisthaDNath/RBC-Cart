package com.java.main.cart.constants;

/**
 * ENUM to hold the Product Type and Price
 * Method to return price for the Product 
 * @author Sharmistha
 * 
 */
public enum ProductType {
	BANANA(20), ORANGE(40.50), APPLE(80), LEMON(5), PEACHE(100);

	private double price;

	private ProductType(double price) {
		this.price = price;
	}
/**
 * Method to return the price for the product
 * @return price
 */
	public double getPrice() {
		return price;

	}
}
