package com.payment_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment_service.repository.TransactionDetailsRepository;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	TransactionDetailsRepository TrnsRepo;

}
