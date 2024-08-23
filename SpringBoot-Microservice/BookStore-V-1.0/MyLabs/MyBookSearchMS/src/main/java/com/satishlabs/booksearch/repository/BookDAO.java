package com.satishlabs.booksearch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satishlabs.booksearch.entity.Book;

@Repository
public interface BookDAO extends JpaRepository<Book, Integer>{
		public List<Book> getBooksByAuthorAndCategory(String author, String category);
		public List<Book> getBooksByAuthor(String author);
		public List<Book> getBooksByCategory(String category);
}
