package com.eeshu.uberreviewservice.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

public class ReviewDto {
    private long id;
    @Column(nullable = false)
    private  String content;
    private double rating;
    @Column(nullable = false)
    @CreatedDate
    private Date createAt;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
}
