package com.order_service.external.client.decoder;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.order_service.exception.CustomException;
import com.order_service.external.client.response.ErrorResponse;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CustomErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		log.info("::{}",response.request().url());
		log.info("::{}",response.request().headers());
		
		try {
			ErrorResponse errorResponse = objectMapper.readValue(response.body().asInputStream(), ErrorResponse.class);
			
			return new CustomException(errorResponse.getErrorMessage(), errorResponse.getErrorCode(), response.status());
		} catch (IOException e) {
			throw new CustomException("Internal Server Error", "INTERNAL _SERVER_ERROR", 500);
		}
	}

}
