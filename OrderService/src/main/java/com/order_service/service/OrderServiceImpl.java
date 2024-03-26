package com.order_service.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order_service.entity.Order;
import com.order_service.model.OrderRequest;
import com.order_service.repository.OrderRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderRepository orderRepo;
	
	
	@Override
	public long placeOrder(OrderRequest orderRequest) {
	
	
		
		log.info("Placing order request: {}", orderRequest);
		
		Order order = Order.builder()
				.amount(orderRequest.getTotalAmount())
				.orderStatus("CREATED")
				.productId(orderRequest.getProductId())
				.orderDate(Instant.now())
				.quantity(orderRequest.getQuantity())
				.build();
		
		order = orderRepo.save(order);
		log.info("Order placed successfully with Order Id: {}", order.getId());
		return order.getId();
	}

}
