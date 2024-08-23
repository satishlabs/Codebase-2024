package com.satishlabs.placeorder.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mybookinventory", schema = "jlcordersdb")
@Schema(description = "Entity representing of BookInventory detials")
public class BookInventory {
	@Id
	@Schema(description = "Unique identifier of the bookId", example = "1")
	@Column(name = "book_id")
	private Integer bookId;

	@Schema(description = "No of books available in BookInventory", example = "1")
	@Column(name = "books_available")
	private int booksAvailable;

	public BookInventory() {
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
