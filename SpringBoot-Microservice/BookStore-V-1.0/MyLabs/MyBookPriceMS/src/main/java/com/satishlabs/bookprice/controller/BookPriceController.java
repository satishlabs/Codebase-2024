package com.satishlabs.bookprice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.satishlabs.bookprice.entity.BookPrice;
import com.satishlabs.bookprice.service.BookPriceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@RestController
@Tag(name = "BookPrice", description = "Operations related to BookPriceMS")
public class BookPriceController {
	static Logger logger = LoggerFactory.getLogger(BookPriceController.class);

	@Autowired
	private BookPriceService bookPriceService;

	@GetMapping("/bookPrice/{bookId}")
	@Operation(summary = "Get Book Price ", description = "Returns books price by bookId")
    @ApiResponse(responseCode = "200", description = "Successful operation")
	public BookPrice getBookPriceById(@PathVariable Integer bookId) {
		logger.info("--- BookPriceController --- getBookPriceById() ---");
		BookPrice bookPrice = bookPriceService.getBookPriceById(bookId);
		return bookPrice;
	}

	@GetMapping("/offeredPrice/{bookId}")
	@Operation(summary = "Get Book Offered Price ", description = "Returns Price Offered rate")
    @ApiResponse(responseCode = "200", description = "Successful operation")
	public double getOfferedPrice(@PathVariable Integer bookId) {
		logger.info("--- BookPriceController --- getOfferedPrice() ---");
		double offeredPrice = bookPriceService.getOfferedPriceById(bookId);
		return offeredPrice;
	}
}
