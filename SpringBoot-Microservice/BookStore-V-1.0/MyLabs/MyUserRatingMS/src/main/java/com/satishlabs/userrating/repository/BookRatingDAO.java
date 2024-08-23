package com.satishlabs.userrating.repository;

import com.satishlabs.userrating.entity.BookRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRatingDAO extends JpaRepository<BookRating, Integer> {
}
