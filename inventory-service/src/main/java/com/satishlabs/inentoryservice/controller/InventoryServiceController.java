package com.satishlabs.inentoryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satishlabs.inentoryservice.entity.Inventory;
import com.satishlabs.inentoryservice.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryServiceController {
	@Autowired
	private InventoryService inventoryService;
	
	@PostMapping
	public ResponseEntity<String> createOrder(@RequestBody Inventory inventory){
		try {
			inventoryService.reserveInventory(inventory);
			return ResponseEntity.ok("Inventory reserved successfully!");
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
	}
}
