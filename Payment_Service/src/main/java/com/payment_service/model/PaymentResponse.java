package com.payment_service.model;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentResponse {
	
	long paymentId;
	String status;
	PaymentMode paymentMode;
	long amount;
	Instant paymentDate;
	long orderId;

}
