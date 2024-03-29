package com.order_service.exception;

import lombok.Data;

@Data
public class CustomException extends RuntimeException {
	
	String errorCode;
	int status;
	public CustomException(String message, String errorCode, int status) {
		super(message);
		this.errorCode = errorCode;
		this.status = status;
	}
	
	

}
