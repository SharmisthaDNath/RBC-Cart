/**
 * 
 */
package com.java.main.cart.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Cart is a shopping basket with ID and Product List
 * @author Sharmistha
 * 
 */
public class Cart {

	private int cartID;
	private List<Product> products = new ArrayList<Product>();

	/**
	 * @return the cartID
	 */
	public int getCartID() {
		return cartID;
	}

	/**
	 * @param cartID
	 *            the cartID to set
	 */
	public void setCartID(int cartID) {
		this.cartID = cartID;
	}

	/**
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}

}