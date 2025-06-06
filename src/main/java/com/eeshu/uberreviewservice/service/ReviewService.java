package com.eeshu.uberreviewservice.service;

import com.eeshu.uberreviewservice.model.Booking;
import com.eeshu.uberreviewservice.model.Review;
import com.eeshu.uberreviewservice.repository.BookingRepository;
import com.eeshu.uberreviewservice.repository.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
@Service
public class ReviewService implements CommandLineRunner {

   private ReviewRepository reviewRepository;
   private BookingRepository bookingRepository;
   public ReviewService(ReviewRepository reviewRepository,
                        BookingRepository bookingRepository) {
       this.reviewRepository = reviewRepository;
       this.bookingRepository = bookingRepository;
   }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("**************");
        Review r=Review.builder()
                .content("Amazing ride quality")
                .rating(5.0).build();
//        reviewRepository.save(r);
        Booking b= Booking.builder()
                .startTime(new Date())
                .endTime(new Date())
                .review(r)
                .build();

bookingRepository.save(b);

    }
}
