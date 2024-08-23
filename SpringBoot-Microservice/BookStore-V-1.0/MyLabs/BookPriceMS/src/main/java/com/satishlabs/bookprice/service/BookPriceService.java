package com.satishlabs.bookprice.service;

import com.satishlabs.bookprice.entity.BookPrice;

public interface BookPriceService {
	public BookPrice getBookPriceById(Integer bookId);
	public double getOfferedPriceById(Integer bookId);
}
