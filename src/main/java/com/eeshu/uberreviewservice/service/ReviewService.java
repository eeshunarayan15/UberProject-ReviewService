package com.eeshu.uberreviewservice.service;

import com.eeshu.uberreviewservice.model.Review;
import com.eeshu.uberreviewservice.repository.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
@Service
public class ReviewService implements CommandLineRunner {

   private ReviewRepository reviewRepository;
   public ReviewService(ReviewRepository reviewRepository) {
       this.reviewRepository = reviewRepository;
   }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("**************");
        Review review=Review.builder()
                .content("Amazing ride quality")


                .rating(5.0).build();
        reviewRepository.save(review);
    }
}
