package com.satishlabs.userrating.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="myuserratings",schema = "jlcratingsdb")
@Schema(description = "Entity representing a UserRating detials")
public class UserRating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rating_id")
    @Schema(description = "Unique identifier of the ratingId", example = "1")
    private Integer ratingId;

    @Schema(description = "Unique identifier of the bookId", example = "1")
    @Column(name = "book_id")
    private Integer bookId;

    @Schema(description = "Unique identifier of the userId", example = "1")
    @Column(name = "user_id")
    private String userId;

    @Schema(description = "Rating given on books", example = "2.5")
    @Column(name = "rating")
    private double rating;

    @Schema(description = "Review given on books", example = "Nice Book!")
    @Column(name = "review")
    private String review;

    public UserRating(){}

    public UserRating(Integer bookId, String userId, double rating, String review) {
        this.bookId = bookId;
        this.userId = userId;
        this.rating = rating;
        this.review = review;
    }

    public UserRating(Integer ratingId, Integer bookId, String userId, double rating, String review) {
        this.ratingId = ratingId;
        this.bookId = bookId;
        this.userId = userId;
        this.rating = rating;
        this.review = review;
    }

    public Integer getRatingId() {
        return ratingId;
    }

    public void setRatingId(Integer ratingId) {
        this.ratingId = ratingId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "UserRating{" +
                "ratingId=" + ratingId +
                ", bookId=" + bookId +
                ", userId='" + userId + '\'' +
                ", rating=" + rating +
                ", review='" + review + '\'' +
                '}';
    }
}

