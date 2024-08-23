package com.satishlabs.userrating.service.impl;

import com.satishlabs.userrating.entity.BookRating;
import com.satishlabs.userrating.entity.UserRating;
import com.satishlabs.userrating.repository.BookRatingDAO;
import com.satishlabs.userrating.repository.UserRatingDAO;
import com.satishlabs.userrating.service.RatingService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Transactional
public class RatingServiceImpl implements RatingService {
    static Logger logger = LoggerFactory.getLogger(RatingServiceImpl.class);

    @Autowired
    private BookRatingDAO bookRatingDAO;

    @Autowired
    private UserRatingDAO userRatingDAO;

    @Override
    public void addUserRating(UserRating userRating) {
        logger.info("--- RatingServiceImpl --- addUserRating() ---");

        //1. add user Rating
        userRatingDAO.save(userRating);

        //2.Calculate the Avg rating for BookId
        int bookId = userRating.getBookId();
        List<UserRating> ratingList = userRatingDAO.getUserRatingByBookId(bookId);
        double sumRating = 0.0;
        for(UserRating ur: ratingList){
            sumRating = sumRating+ur.getRating();
        }
        double avgRating = sumRating/ratingList.size();

        //3.Update BookRating in UserRatingMS (Local)
        BookRating bookRating = bookRatingDAO.findById(bookId).get();
        bookRating.setAvgRating(avgRating);
        bookRatingDAO.save(bookRating);

        //4.Update BookRating in BookSearchMS
        //Invoking BookRating-MS
        RestTemplate bookSearchRest=new RestTemplate();
        String endpoint="http://localhost:8000/updateBookRating";
        bookSearchRest.put(endpoint, bookRating);

    }

    @Override
    public List<UserRating> getUserRatingByUserId(String userId) {
        logger.info("--- RatingServiceImpl --- getUserRatingByUserId() ---");
        return userRatingDAO.getUserRatingByUserId(userId);
    }

    @Override
    public void updateBookRating(BookRating bookRating) {
        logger.info("--- RatingServiceImpl --- updateBookRating() ---");
        bookRatingDAO.save(bookRating);
    }

    @Override
    public BookRating getBookRatingByBookId(Integer bookId) {
        logger.info("--- RatingServiceImpl --- getBookRatingByBookId() ---");
        return bookRatingDAO.findById(bookId).get();
    }
}
