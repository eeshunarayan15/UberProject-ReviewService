package com.eeshu.uberreviewservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@PrimaryKeyJoinColumn(name = "passenger_review_id")
public class PassengerReview extends Review{
    private String passengerReviewComment;
}
