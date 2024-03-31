package com.order_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order_service.model.OrderRequest;
import com.order_service.model.OrderResponse;
import com.order_service.service.OrderService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/order")
@Log4j2
public class OrderController {
	
	@Autowired
	OrderService orderSer;
	
	@PostMapping("/placeOrder")
	public ResponseEntity<Long> placeOrder(@RequestBody OrderRequest orderRequest) {
		long orderId = orderSer.placeOrder(orderRequest);
		log.info("Order Id: {}", orderId);
		
		return new ResponseEntity<>(orderId, HttpStatus.OK);
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity<OrderResponse> getOrderDetails(@PathVariable long orderId) {
		OrderResponse orderResponse = orderSer.getOrderDetails(orderId);
		return new ResponseEntity<>(orderResponse, HttpStatus.OK);
	}

}
