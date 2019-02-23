package com.imooc.o2o.exceptions;

public class ShopOperationException extends RuntimeException{
	/**
	 * ShopOperationException 继承RuntimeException
	 */
	private static final long serialVersionUID = 2361446884822298905L;

	public ShopOperationException(String msg) {
		super(msg);
	}

}
