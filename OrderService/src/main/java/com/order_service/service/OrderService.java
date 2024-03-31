package com.order_service.service;

import com.order_service.model.OrderRequest;
import com.order_service.model.OrderResponse;

public interface OrderService {

	long placeOrder(OrderRequest orderRequest);
	OrderResponse getOrderDetails(long orderId);

}
