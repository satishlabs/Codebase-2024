package com.satishlabs.booksearch.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mybookinventory", schema = "jlcbooksdb")
@Schema(description = "Entity representing a BookInventory detials")
public class BookInventory {
	@Id
	@Column(name = "book_id")
    @Schema(description = "Unique identifier of the book")
	private Integer bookId;

	@Column(name = "books_available")
    @Schema(description = "Books Availablity")
	private int booksAvailable;

	public BookInventory() {
	}

	public BookInventory(int booksAvailable) {
		super();
		this.booksAvailable = booksAvailable;
	}

	public BookInventory(Integer bookId, int booksAvailable) {
		super();
		this.bookId = bookId;
		this.booksAvailable = booksAvailable;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public int getBooksAvailable() {
		return booksAvailable;
	}

	public void setBooksAvailable(int booksAvailable) {
		this.booksAvailable = booksAvailable;
	}

	@Override
	public String toString() {
		return "BookInventory [bookId=" + bookId + ", booksAvailable=" + booksAvailable + "]";
	}

}
