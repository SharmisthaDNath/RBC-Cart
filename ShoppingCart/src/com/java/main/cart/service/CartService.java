package com.java.main.cart.service;

import com.java.main.cart.exception.CartException;
import com.java.main.cart.model.Cart;
import com.java.main.cart.model.Product;

public interface CartService {

	/**
	 * Method to add product in Cart
	 * @param product
	 * @return true/false based on product
	 */
	public void addProduct(Product product)throws CartException;

	/**
	 * Method to remove product from Cart
	 * @param product
	 * @return true/false based on product
	 */
	public void removeProduct(Product product)throws CartException;

	/**
	 * Method to calculate total Price for the Products added in the cart
	 * @return total cart price
	 * 
	 */
	public double calculateCartPrice()throws CartException;

	/**
	 * Method to check if my Cart is empty
	 * @return
	 */
	public boolean isCartEmpty(Cart cart)throws CartException;

}