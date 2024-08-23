package com.satishlabs.placeorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satishlabs.placeorder.entity.BookInventory;

public interface BookInventoryDAO extends JpaRepository<BookInventory, Integer>{

}
