package com.product_service.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product_service.entity.Product;
import com.product_service.exception.ProductServiceCustomException;
import com.product_service.model.ProductRequest;
import com.product_service.model.ProductResponse;
import com.product_service.repository.ProductRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepo;

	@Override
	public long addProduct(ProductRequest productRequest) {
		log.info("Adding product....");
		
		Product product = Product.builder()
				.productName(productRequest.getName())
				.price(productRequest.getPrice())
				.quantity(productRequest.getQuantity())
				.build();
		productRepo.save(product);
		
		log.info("Product Added.....");
		
		return product.getId();
	}

	@Override
	public ProductResponse getProductById(long productId) {
		log.info("Get the product for productid: {}", productId);
		Product product = productRepo.findById(productId).orElseThrow(() -> new ProductServiceCustomException("Product with given id not found", "PRODUCT_NOT_FOUND"));
		
		ProductResponse productResponse = new ProductResponse();
		BeanUtils.copyProperties(product, productResponse);
		return productResponse;
	}

	@Override
	public void reduceQuantity(long productId, long quantity) {
		
		log.info("Reduce quantity {} for id: ", quantity, productId);
		
		Product product = productRepo.findById(productId).orElseThrow(() -> new ProductServiceCustomException("Product not found with given id: "+ productId, "PRODUCT_NOT_FOUND"));
			
		if (product.getQuantity() < quantity) {
			throw new ProductServiceCustomException("Product does not have sufficient Quantity", "INSUFFICIENT_QUANTITY");
		}
		
		product.setQuantity(product.getQuantity() - quantity);
		productRepo.save(product);
		
		log.info("Product updated successfully");
		
	}

}
