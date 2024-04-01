package com.payment_service.service;

import com.payment_service.model.PaymentRequest;
import com.payment_service.model.PaymentResponse;

public interface PaymentService {

	Long doPayment(PaymentRequest paymentRequest);
	PaymentResponse getPaymentDetailsByOrderId(long orderId);

}
