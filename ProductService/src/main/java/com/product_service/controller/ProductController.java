package com.product_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product_service.model.ProductRequest;
import com.product_service.model.ProductResponse;
import com.product_service.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping
	public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest) {
		long productId = productService.addProduct(productRequest);
		
		return new ResponseEntity<>(productId, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") long productId) {
		ProductResponse productResponse = productService.getProductById(productId);
		return new ResponseEntity<>(productResponse, HttpStatus.OK);
	}
	
	@PutMapping("/reduceQuantity/{id}")
	public ResponseEntity<Void> reduceQuantity(@PathVariable("id") long productId, @RequestParam long quantity) {
		productService.reduceQuantity(productId, quantity);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
