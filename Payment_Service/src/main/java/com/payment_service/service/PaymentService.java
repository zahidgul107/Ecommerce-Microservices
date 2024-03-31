package com.payment_service.service;

import com.payment_service.model.PaymentRequest;

public interface PaymentService {

	Long doPayment(PaymentRequest paymentRequest);

}
