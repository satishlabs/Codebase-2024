package com.satishlabs.booksearch.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mybookratings", schema = "jlcbooksdb")
@Schema(description = "BookRating Contains bookId, avgRating, numberOfSearches")
public class BookRating {

	@Id
	@Column(name = "book_id")
    @Schema(description = "This is bookId", example = "101")
	private Integer bookId;

	@Column(name = "avg_rating")
    @Schema(description = "Average rating of books", example = "2.0")
	private double avgRating;

	@Column(name = "number_of_searches")
    @Schema(description = "Number of book searches", example = "1")
	private int numberOfSearches;

	public BookRating() {
	}

	public BookRating(double avgRating, int numberOfSearches) {
		super();
		this.avgRating = avgRating;
		this.numberOfSearches = numberOfSearches;
	}

	public BookRating(Integer bookId, double avgRating, int numberOfSearches) {
		super();
		this.bookId = bookId;
		this.avgRating = avgRating;
		this.numberOfSearches = numberOfSearches;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}

	public int getNumberOfSearches() {
		return numberOfSearches;
	}

	public void setNumberOfSearches(int numberOfSearches) {
		this.numberOfSearches = numberOfSearches;
	}

	@Override
	public String toString() {
		return "BookRating [bookId=" + bookId + ", avgRating=" + avgRating + ", numberOfSearches=" + numberOfSearches
				+ "]";
	}

}
