package com.satishlabs.userrating.controller;

import com.satishlabs.userrating.entity.BookRating;
import com.satishlabs.userrating.entity.UserRating;
import com.satishlabs.userrating.service.RatingService;
import com.satishlabs.userrating.service.impl.RatingServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Tag(name = "UserRating", description = "UserRating operations related to UserRatingMS")
public class RatingController {
    static Logger logger = LoggerFactory.getLogger(RatingServiceImpl.class);

    @Autowired
    private RatingService ratingService;

    @PutMapping("/addUserRating")
    @Operation(summary = "User Rating", description = "User Rating Info")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    public void addUserRating(@RequestBody UserRating userRating){
        logger.info("---RatingController---addUserRating()-----");
        ratingService.addUserRating(userRating);
    }

    @Operation(summary = "Get UserRating", description = "Get User Rating By UserId")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @GetMapping("/userRatings/{userId}")
    public List<UserRating> getUserRatingByUserId(@PathVariable String userId){
        logger.info("---RatingController---getUserRatingByUserId()-----");
        return ratingService.getUserRatingByUserId(userId);
    }

    @Operation(summary = "Get BookRating", description = "Get Book Rating By BookId")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    @GetMapping("/bookRatings/{bookId}")
    public BookRating getBookRatingByBookId(@PathVariable String bookId){
        logger.info("---RatingController---getBookRatingByBookId()-----");
        return ratingService.getBookRatingByBookId(Integer.valueOf(bookId));
    }

}

