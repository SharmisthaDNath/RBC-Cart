/**
 * 
 */
package com.java.main.cart.model;

import com.java.main.cart.constants.ProductType;

/**
 * Shopping items with type and quantity
 * @author Sharmistha
 *
 */
public class Product {

	private int Quantity;
	private ProductType type;

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return Quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	/**
	 * @return the type
	 */
	public ProductType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(ProductType type) {
		this.type = type;
	}
}
