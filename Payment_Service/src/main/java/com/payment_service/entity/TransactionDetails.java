package com.payment_service.entity;

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
@Table(name = "TRANSACTION_DETAILS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	@Column(name = "ORDER_ID")
	long orderId;
	
	@Column(name = "MODE")
	String paymentMode;
	
	@Column(name = "REFERENCE_NUMBER")
	String referenceNumber;
	
	@Column(name = "PAYMENT_DATE")
	Instant paymentDate;
	
	@Column(name = "STATUS")
	String paymentStatus;
	
	@Column(name = "AMOUNT")
	long amount;

}
