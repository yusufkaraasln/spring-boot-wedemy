package com.karaaslan.wedemy.controller;


import com.karaaslan.wedemy.dao.AppDAO;
import com.karaaslan.wedemy.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ReviewContorller {

    private AppDAO appDAO;


    @Autowired
    public ReviewContorller(AppDAO appDAO) {
        this.appDAO = appDAO;
    }


    @GetMapping("/courses/{id}/reviews")
    public List<Review> getReviewsById(@PathVariable int id) {
        return appDAO.getCourseReviews(id);

    }

    @GetMapping("/courses/{id}/reviews/{reviewId}")
    public Review getReviewById(@PathVariable int id, @PathVariable int reviewId) {
        Review result = appDAO.getReviewByIdAndCourseId(id, reviewId);

        System.out.println("result: " + result);

        return result;
    }


}
