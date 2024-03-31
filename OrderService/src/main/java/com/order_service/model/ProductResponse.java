package com.order_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ProductResponse {
	
	private String productName;
	private long id;
	private long price;
	private long quantity;

}
