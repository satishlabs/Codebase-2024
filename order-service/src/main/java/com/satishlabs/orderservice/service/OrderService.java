package com.satishlabs.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.satishlabs.orderservice.entity.Order;
import com.satishlabs.orderservice.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	public void createOrder(Order order) {
		order.setStatus("CREATED");
		orderRepository.save(order);
		
		//Call Payment Service
		ResponseEntity<String> paymentResponse = restTemplate.postForEntity("http://localhost:8081/payments", order, String.class);
		if(paymentResponse.getStatusCode() != HttpStatus.OK) {
			throw new RuntimeException("Payment failed, rolling back order");
		}
		
		//Call Inventory Service
		ResponseEntity<String> inventoryResponse = restTemplate.postForEntity("http://localhost:8081/payments", order, String.class);
		if(inventoryResponse.getStatusCode() != HttpStatus.OK) {
			throw new RuntimeException("Inventory failed, rolling back order");
		}
		order.setStatus("COMPLETED");
		orderRepository.save(order);
	}
}
