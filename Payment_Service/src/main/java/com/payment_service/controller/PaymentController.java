package com.payment_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment_service.model.PaymentRequest;
import com.payment_service.model.PaymentResponse;
import com.payment_service.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@PostMapping
	public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest){
		return new ResponseEntity<>(paymentService.doPayment(paymentRequest), HttpStatus.OK);
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity<PaymentResponse> getPaymentDetailsByOrderId(@PathVariable("orderId") long orderId) {
		return new ResponseEntity<>(paymentService.getPaymentDetailsByOrderId(orderId), HttpStatus.OK);
	}

}
