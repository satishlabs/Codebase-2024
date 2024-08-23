package com.satishlabs.bookprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satishlabs.bookprice.entity.BookPrice;

public interface BookPriceDAO extends JpaRepository<BookPrice, Integer>{

}
