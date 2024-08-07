package com.satishlabs.inentoryservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satishlabs.inentoryservice.entity.Inventory;
import com.satishlabs.inentoryservice.repository.InventoryRepository;

import jakarta.transaction.Transactional;

@Service
public class InventoryService {
	@Autowired
	private InventoryRepository inventoryRepository;
	
	
	@Transactional
	public void reserveInventory(Inventory inventory) {
		inventory.setStatus("RESERVED");
		inventoryRepository.save(inventory);
	}
}
