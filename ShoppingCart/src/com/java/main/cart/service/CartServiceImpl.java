/**
 * 
 */
package com.java.main.cart.service;

import com.java.main.cart.exception.CartException;
import com.java.main.cart.model.Cart;
import com.java.main.cart.model.Product;

/**
 * Implementation class for the CartServices
 * @author Sharmistha
 * 
 */
public class CartServiceImpl implements CartService {

	private final Cart cart;

	public CartServiceImpl(Cart cart) {
		this.cart = cart;
	}

	public void addProduct(Product product) throws CartException {
		if (null == product) {
			throw new CartException(" No Product selected in cart "
					+ cart.getCartID());
		}
		cart.getProducts().add(product);
	}

	public void removeProduct(Product product) throws CartException {
		if (isCartEmpty(cart)) {
			throw new CartException(" Cart is empty ");
		}
		cart.getProducts().remove(product);
	}

	public double calculateCartPrice() throws CartException {
		double totalPrice = 0;
		if (!isCartEmpty(cart)) {
			for (Product product : cart.getProducts()) {
				if (product.getQuantity() > 0) {
					totalPrice += product.getType().getPrice()
							* product.getQuantity();
				} else {
					throw new CartException(
							"please select quantity for the product "
									+ product.getType());
				}
			}
		}

		return totalPrice;

	}

	public boolean isCartEmpty(Cart cart) {
		return (null == cart || null == cart.getProducts() || cart
				.getProducts().isEmpty());
	}
}
