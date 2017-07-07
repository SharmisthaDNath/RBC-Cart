/**
 * 
 */
package com.java.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.java.main.cart.constants.ProductType;
import com.java.main.cart.exception.CartException;
import com.java.main.cart.model.Cart;
import com.java.main.cart.model.Product;
import com.java.main.cart.service.CartService;
import com.java.main.cart.service.CartServiceImpl;

/**
 * Test all the Cart services exposed
 * 
 * @author Sharmistha
 * 
 */
public class CartServiceTest {

	CartService cartService;
	Product product;
	Cart cart;

	@Before
	public void setUp() throws CartException {
		product = new Product();
		product.setQuantity(3);
		product.setType(ProductType.ORANGE);

		cart = new Cart();
		cart.setCartID(1);
		cartService = new CartServiceImpl(cart);
		cartService.addProduct(product);

		product = new Product();
		product.setQuantity(1);
		product.setType(ProductType.LEMON);
		cartService.addProduct(product);
	}

	@Test
	public void testCalculateCartPrice() {
		try {
			assertTrue(126.5 == cartService.calculateCartPrice());
		} catch (CartException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testCalculateCartPriceWithNoProduct() {
		cartService = new CartServiceImpl(new Cart());
		try {
			assertTrue(0.0 == cartService.calculateCartPrice());
		} catch (CartException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testAddProduct() {
		try {
			cartService.addProduct(product);
			assertEquals(1, product.getQuantity());
		} catch (CartException e) {
			e.printStackTrace();
			fail();
		}

	}

	@Test(expected = CartException.class)
	public void testCalculateCartPriceNoQuantity() throws CartException {
		product.setQuantity(0);
		cartService.calculateCartPrice();
	}

	@Test(expected = CartException.class)
	public void testAddProductWithException() throws CartException {
		cart = new Cart();
		cart.setCartID(1);
		cart.getProducts().add(null);
		cartService = new CartServiceImpl(cart);
		cartService.addProduct(null);
	}

	@Test
	public void testAddProductWithNull() {
		cart = new Cart();
		cart.setCartID(1);
		cart.getProducts().add(null);
		cartService = new CartServiceImpl(cart);
		try {
			cartService.addProduct(null);
		} catch (CartException e) {
			assertTrue(null != e.getMessage());
		}
	}

	@Test
	public void testRemoveProduct() {
		try {

			product = new Product();
			product.setQuantity(1);
			product.setType(ProductType.LEMON);

			cart = new Cart();
			cart.setCartID(1);
			cart.getProducts().add(product);

			cartService = new CartServiceImpl(cart);
			cartService.removeProduct(product);
			assertEquals(true, cart.getProducts().isEmpty());
		} catch (CartException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test(expected = CartException.class)
	public void testRemoveProductWithException() throws CartException {
		cartService = new CartServiceImpl(new Cart());
		cartService.removeProduct(null);

	}

	@Test
	public void testRemoveProductWithNull() {
		product = new Product();
		product.setQuantity(1);
		product.setType(ProductType.LEMON);

		cart = new Cart();
		cart.setCartID(1);
		cart.getProducts().add(product);
		cartService = new CartServiceImpl(cart);
		try {
			cartService.removeProduct(null);
		} catch (CartException e) {
			assertTrue(null != e.getMessage());
		}
	}

	@Test
	public void testIsCartEmptyWithNull() {
		cart = null;
		try {
			assertEquals(true, cartService.isCartEmpty(cart));
		} catch (CartException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testIsCartEmpty() {
		cart = new Cart();
		cart.getProducts().add(product);
		try {
			assertEquals(false, cartService.isCartEmpty(cart));
		} catch (CartException e) {
			e.printStackTrace();
			fail();
		}
	}
}
