/**
 * 
 */
package com.java.main.cart.exception;

/**
 * @author Sharmistha
 *
 */
public class CartException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	


	public CartException(String message){
		super(message);
		this .message = message;				
	}
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CartException [message=" + message + "]";
	}

}
