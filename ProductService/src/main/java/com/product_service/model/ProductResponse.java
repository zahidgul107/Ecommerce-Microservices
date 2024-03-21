package com.product_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductResponse {
	
	private String productName;
	private long id;
	private long price;
	private long quantity;

}
