package com.product_service.service;

import com.product_service.model.ProductRequest;
import com.product_service.model.ProductResponse;

public interface ProductService {

	long addProduct(ProductRequest productRequest);
	ProductResponse getProductById(long productId);

}
