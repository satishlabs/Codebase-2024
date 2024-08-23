package com.satishlabs.bookprice.service.Impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satishlabs.bookprice.entity.BookPrice;
import com.satishlabs.bookprice.repository.BookPriceDAO;
import com.satishlabs.bookprice.service.BookPriceService;

@Service
public class BookPriceServiceImpl implements BookPriceService {
	static Logger logger = LoggerFactory.getLogger(BookPriceServiceImpl.class);

	@Autowired
	private BookPriceDAO bookPriceDAO;

	@Override
	public BookPrice getBookPriceById(Integer bookId) {
		logger.info("--- BookPriceServiceImpl -- getBookPriceById() ---");
		BookPrice bookPrice = null;
		Optional<BookPrice> opt = bookPriceDAO.findById(bookId);
		if (opt.isPresent()) {
			bookPrice = opt.get();
		}
		return bookPrice;
	}

	@Override
	public double getOfferedPriceById(Integer bookId) {
		logger.info("--- BookPriceServiceImpl -- getBookPriceById() ---");
		double offerPrice = 0.0;
		Optional<BookPrice> opt = bookPriceDAO.findById(bookId);
		if (opt.isPresent()) {
			BookPrice bookPrice = opt.get();
			double price = bookPrice.getPrice();
			double offer = bookPrice.getOffer();

			if (offer <= 0) {
				return price;
			}
			offerPrice = price - price * offer / 100;
		}
		return offerPrice;
	}

}
