package com.eeshu.uberreviewservice.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Service;

import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "review")
@Inheritance(strategy = InheritanceType.JOINED )
public class Review extends BaseModel {

@Column(nullable = false)
    private  String content;
    private double rating;



}
