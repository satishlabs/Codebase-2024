package com.satishlabs.paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satishlabs.paymentservice.entity.Payment;
import com.satishlabs.paymentservice.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentServiceController {
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping
	public ResponseEntity<String> createOrder(@RequestBody Payment payment){
		try {
			paymentService.processPayment(payment);
			return ResponseEntity.ok("Payment processed successfully!");
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
	}
}
