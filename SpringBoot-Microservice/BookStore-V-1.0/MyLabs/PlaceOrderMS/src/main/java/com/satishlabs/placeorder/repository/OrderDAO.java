package com.satishlabs.placeorder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satishlabs.placeorder.entity.Order;

public interface OrderDAO extends JpaRepository<Order, Integer>{
	List<Order> findOrdersByUserId(String userId);
}
