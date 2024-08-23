package com.satishlabs.booksearch.service.Impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.satishlabs.booksearch.dto.BookInfo;
import com.satishlabs.booksearch.dto.BookPriceInfo;
import com.satishlabs.booksearch.entity.Book;
import com.satishlabs.booksearch.entity.BookInventory;
import com.satishlabs.booksearch.entity.BookRating;
import com.satishlabs.booksearch.repository.BookDAO;
import com.satishlabs.booksearch.repository.BookInventoryDAO;
import com.satishlabs.booksearch.repository.BookRatingDAO;
import com.satishlabs.booksearch.service.BookService;

@Service
@Transactional
public class BookServiceImpl implements BookService {
	static Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

	@Autowired
	private BookDAO bookDAO;

	@Autowired
	private BookRatingDAO bookRatingDAO;

	@Autowired
	private BookInventoryDAO bookInventoryDAO;

	@Override
	public List<Book> getBooks(String author, String category) {
		logger.info("--- BookServiceImpl --- getBooks() ---");

		if ("All Authors".equals(author) && "All Categories".equals(category)) {
			return bookDAO.findAll();
		}

		if ("All Authors".equals(author)) {
			return bookDAO.getBooksByCategory(category);
		}

		if ("All Categories".equals(category)) {
			return bookDAO.getBooksByAuthor(author);
		}

		return bookDAO.getBooksByAuthorAndCategory(author, category);
	}

	@Override
	public BookInfo getBookInfo(Integer bookId) {
		logger.info("--- BookServiceImpl --- getBookInfo() ---");
		BookInfo bookInfo = new BookInfo();
		// 1. Book Details
		Optional<Book> myOpts = bookDAO.findById(bookId);
		if (myOpts.isPresent()) {
			Book book = bookDAO.findById(bookId).get();
			bookInfo.setBookId(book.getBookId());
			bookInfo.setBookName(book.getBookName());
			bookInfo.setAuthor(book.getAuthor());
			bookInfo.setPublications(book.getPublications());
			bookInfo.setCategory(book.getCategory());
		}

		// 2. Book Price Details(Invoke BookPrice- MS)
		RestTemplate restTemplate = new RestTemplate();
		String endpoint = "http://localhost:9000/bookPrice/" + bookId;
		BookPriceInfo bookPriceInfo = restTemplate.getForObject(endpoint, BookPriceInfo.class);
		bookInfo.setPrice(bookPriceInfo.getPrice());
		bookInfo.setOffer(bookPriceInfo.getOffer());

		// 3. Book Rating Details
		BookRating bookRating = bookRatingDAO.findById(bookId).get();
		bookInfo.setAvgRating(bookRating.getAvgRating());
		bookInfo.setNumberOfSearches(bookRating.getNumberOfSearches());
		
		//4 Book Inventory Details
		BookInventory bookInventory = bookInventoryDAO.findById(bookId).get();
		bookInfo.setBooksAvailable(bookInventory.getBooksAvailable());
		
		return bookInfo;
	}

	@Override
	public void updateBookRating(BookRating bookRating) {
		logger.info("--- BookServiceImpl --- updateBookRating() ---");
		bookRatingDAO.save(bookRating);
	}

	@Override
	public void updateBookInventory(BookInventory bookInventory) {
		logger.info("--- BookServiceImpl --- updateBookInventory() ---");
		bookInventoryDAO.save(bookInventory);
	}

}
