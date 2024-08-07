package com.satishlabs.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satishlabs.orderservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
