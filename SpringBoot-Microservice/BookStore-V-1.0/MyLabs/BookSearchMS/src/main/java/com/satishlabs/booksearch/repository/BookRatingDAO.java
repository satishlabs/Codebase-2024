package com.satishlabs.booksearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.satishlabs.booksearch.entity.BookRating;

@Repository
public interface BookRatingDAO extends JpaRepository<BookRating, Integer>{

}
