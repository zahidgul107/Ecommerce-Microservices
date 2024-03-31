package com.order_service.model;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {
	
	long orderId;
	Instant orderDate;
	String orderStatus;
	long amount;
	ProductDetails productDetails;
	
	@Data
	@AllArgsConstructor
	@Builder
	@NoArgsConstructor
	public static class ProductDetails {
		
		private String productName;
		private long id;
		private long price;
		private long quantity;

	}

}
