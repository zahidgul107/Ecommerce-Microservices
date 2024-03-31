package com.payment_service.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment_service.entity.TransactionDetails;
import com.payment_service.model.PaymentRequest;
import com.payment_service.repository.TransactionDetailsRepository;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	TransactionDetailsRepository TrnsRepo;

	@Override
	public Long doPayment(PaymentRequest paymentRequest) {
		TransactionDetails txnDetails = TransactionDetails.builder()
				.amount(paymentRequest.getAmount())
				.orderId(paymentRequest.getOrderId())
				.paymentMode(paymentRequest.getPaymentMode().name())
				.paymentDate(Instant.now())
				.paymentStatus("SUCCESS")
				.referenceNumber(paymentRequest.getReferenceNumber())
				.build();
		
		TrnsRepo.save(txnDetails);
		return txnDetails.getId();
	}

}
