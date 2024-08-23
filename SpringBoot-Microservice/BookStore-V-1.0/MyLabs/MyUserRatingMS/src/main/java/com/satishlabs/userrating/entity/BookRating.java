package com.satishlabs.userrating.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mybookratings", schema = "jlcratingsdb")
@Schema(description = "Entity representing a BookRating detials")
public class BookRating {
    @Id
    @Column(name = "book_id")
    @Schema(description = "Unique identifier of the bookId", example = "1")
    private Integer bookId;

    @Schema(description = "Avg ratings of book", example = "5")
    @Column(name = "avg_rating")
    private double avgRating;

    @Schema(description = "Number of book searches", example = "5")
    @Column(name = "number_of_searches")
    private int numberOfSearches;

    public BookRating(){}

    public BookRating(double avgRating, int numberOfSearches) {
        this.avgRating = avgRating;
        this.numberOfSearches = numberOfSearches;
    }

    public BookRating(Integer bookId, double avgRating, int numberOfSearches) {
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
        return "BookRating{" +
                "bookId=" + bookId +
                ", avgRating=" + avgRating +
                ", numberOfSearches=" + numberOfSearches +
                '}';
    }
}

