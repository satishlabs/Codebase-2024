package com.satishlabs.booksearch.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satishlabs.booksearch.dto.BookInfo;
import com.satishlabs.booksearch.entity.Book;
import com.satishlabs.booksearch.entity.BookInventory;
import com.satishlabs.booksearch.entity.BookRating;
import com.satishlabs.booksearch.service.BookService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin
@Tag(name = "Books", description = "Operations related to BookSearchMS")
public class BookSearchController {
	static Logger logger = LoggerFactory.getLogger(BookSearchController.class);

	@Autowired
	private BookService bookService;

	@GetMapping("/mybooks/{author}/{category}")
	@Operation(summary = "Get a list of all books by author and category", description = "Returns a list of all available books based on author and category")
    @ApiResponse(responseCode = "200", description = "Successful operation")
	public List<Book> getBooks(@PathVariable String author, @PathVariable String category) {
		logger.info("--- BookSearchController --- getBooks() ---");
		System.out.println(author + "\t\t" + category);
		return bookService.getBooks(author, category);
	}

	@GetMapping("/mybook/{bookId}")
	@Operation(summary = "Get a book from BookInfo", description = "Returns a book details based on bookId")
    @ApiResponse(responseCode = "200", description = "Successful operation")
	public BookInfo getBookById(@PathVariable Integer bookId) {
		logger.info("--- BookSearchController --- getBookById() ---");
		return bookService.getBookInfo(bookId);
	}

	@PutMapping("/updateBookRating")
	@Operation(summary = "Update bookRating", description = "Returns all book ratings")
    @ApiResponse(responseCode = "200", description = "Successful operation")
	public void updateBookRating(@RequestBody BookRating bookRating) {
		logger.info("--- BookSearchController --- updateBookRating() ---");
		bookService.updateBookRating(bookRating);
	}

	@PutMapping("/updateBookInventory")
	@Operation(summary = "Update BookInventory", description = "Returns all Updated book Inventory")
    @ApiResponse(responseCode = "200", description = "Successful operation")
	public void updateBookInventory(@RequestBody BookInventory bookInventory) {
		logger.info("--- BookSearchController --- updateBookInventory() ---");
		bookService.updateBookInventory(bookInventory);
	}

}
