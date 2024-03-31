package com.order_service.external.client.request;

import com.order_service.model.PaymentMode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRequest {
	
	long orderId;
	long amount;
	String referenceNumber;
	PaymentMode paymentMode;

}
