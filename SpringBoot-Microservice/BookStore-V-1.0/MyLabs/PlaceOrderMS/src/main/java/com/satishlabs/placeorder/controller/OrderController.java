package com.satishlabs.placeorder.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satishlabs.placeorder.dto.OrderInfo;
import com.satishlabs.placeorder.entity.Order;
import com.satishlabs.placeorder.service.OrderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@RestController
@Tag(name = "Orders", description = "Orders operations related to PlaceOrderMS")
public class OrderController {
	static Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderService orderService;
	
	@PutMapping("/placeorder")
	@Operation(summary = "Place Order Info", description = "Place all OrderInfo")
    @ApiResponse(responseCode = "200", description = "Successful operation")
	public void placeOrder(@RequestBody OrderInfo orderInfo) {
		logger.info("--- OrderController --- placeOrder() ---");
		orderService.placeOrder(orderInfo);
	}
	
	@GetMapping("/myorders/{userId}")
	@Operation(summary = "Get Orders By UserId", description = "Returns OrdersList based on userId")
    @ApiResponse(responseCode = "200", description = "Successful operation")
	public List<Order> getOrdersByUserId(@PathVariable String userId){
		logger.info("--- OrderController --- getOrdersByUserId() ---");
		List<Order> ordersList = orderService.getOrdersByUserId(userId);
		return ordersList;
	}
}
