package com.satishlabs.inentoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satishlabs.inentoryservice.entity.Inventory;


public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
