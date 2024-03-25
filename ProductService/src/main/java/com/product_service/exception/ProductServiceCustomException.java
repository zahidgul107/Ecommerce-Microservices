package com.product_service.exception;

import lombok.Data;

@Data
public class ProductServiceCustomException extends RuntimeException {
	
	private String errorCode;
	
	public ProductServiceCustomException(String message, String errroCode) {
		super(message);
		this.errorCode = errorCode;
	}

}
