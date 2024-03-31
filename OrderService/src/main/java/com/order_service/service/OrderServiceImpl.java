package com.order_service.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order_service.entity.Order;
import com.order_service.exception.CustomException;
import com.order_service.external.client.PaymentService;
import com.order_service.external.client.ProductService;
import com.order_service.external.client.request.PaymentRequest;
import com.order_service.model.OrderRequest;
import com.order_service.model.OrderResponse;
import com.order_service.model.ProductResponse;
import com.order_service.repository.OrderRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepo;
	@Autowired
	ProductService productService;
	@Autowired
	PaymentService paymentService;
	@Autowired
	RestTemplate restTemplate;

	@Override
	public long placeOrder(OrderRequest orderRequest) {

		log.info("Placing order request: {}", orderRequest);
		productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());

		log.info("Creating Order with status CREATED");
		Order order = Order.builder().amount(orderRequest.getTotalAmount()).orderStatus("CREATED")
				.productId(orderRequest.getProductId()).orderDate(Instant.now()).quantity(orderRequest.getQuantity())
				.build();

		order = orderRepo.save(order);

		PaymentRequest paymentRequest = PaymentRequest.builder().orderId(order.getId())
				.paymentMode(orderRequest.getPaymentMode()).amount(orderRequest.getTotalAmount()).build();

		String orderStatus = null;
		try {
			paymentService.doPayment(paymentRequest);
			orderStatus = "PLACED";
		} catch (Exception e) {
			orderStatus = "PAYMENT_FAILED";
		}
		order.setOrderStatus(orderStatus);
		orderRepo.save(order);
		log.info("Order placed successfully with Order Id: {}", order.getId());
		return order.getId();
	}

	@Override
	public OrderResponse getOrderDetails(long orderId) {
		Order order = orderRepo.findById(orderId)
				.orElseThrow(() -> new CustomException("Order with the given id not exist", "NOT_FOUND", 404));

		ProductResponse productResponse = restTemplate.getForObject("http://PRODUCT-SERVICE/product/" + order.getProductId(),
				ProductResponse.class);

		OrderResponse.ProductDetails productDetails = OrderResponse.ProductDetails.builder()
				.productName(productResponse.getProductName()).build();
		
		OrderResponse orderRep = OrderResponse.builder().orderId(order.getId()).amount(order.getAmount())
				.orderStatus(order.getOrderStatus()).orderDate(order.getOrderDate()).productDetails(productDetails).build();
		return orderRep;
	}

}
