package com.order_service.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORDER_DETAILS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	@Column(name = "PRODUCT_ID")
	long productId;
	
	@Column(name = "QUANTITY")
	long quantity;
	
	@Column(name = "ORDER_DATE")
	Instant orderDate;
	
	@Column(name = "ORDER_STATUS")
	String orderStatus;
	
	@Column(name = "AMOUNT")
	long amount;
}
