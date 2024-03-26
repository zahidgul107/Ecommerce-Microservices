package com.order_service.service;

import com.order_service.model.OrderRequest;

public interface OrderService {

	long placeOrder(OrderRequest orderRequest);

}
