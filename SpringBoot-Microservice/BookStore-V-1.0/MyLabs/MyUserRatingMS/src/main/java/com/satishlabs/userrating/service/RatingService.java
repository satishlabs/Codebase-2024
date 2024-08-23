package com.satishlabs.userrating.service;

import com.satishlabs.userrating.entity.BookRating;
import com.satishlabs.userrating.entity.UserRating;

import java.util.List;

public interface RatingService {
    public void addUserRating(UserRating userRating);
    public List<UserRating> getUserRatingByUserId(String userId);
    public void updateBookRating(BookRating bookRating);
    public BookRating getBookRatingByBookId(Integer bookId);
}
