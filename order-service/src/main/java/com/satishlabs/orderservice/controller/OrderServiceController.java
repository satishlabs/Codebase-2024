package com.satishlabs.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satishlabs.orderservice.entity.Order;
import com.satishlabs.orderservice.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderServiceController {
	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public ResponseEntity<String> createOrder(@RequestBody Order order){
		try {
			orderService.createOrder(order);
			return ResponseEntity.ok("Order created successfully!");
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
	}
}
