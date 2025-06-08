package com.eeshu.uberreviewservice.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.domain.Page;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "booking")
public class Booking extends BaseModel{
   @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private  Review review;//we have defiend one to one relationship between booking and review

     @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;


    @Temporal(value = TemporalType.TIMESTAMP)
    private Date startTime;


    @Temporal(value = TemporalType.TIMESTAMP)
    private Date endTime;

    private long totalDistance;
    @ManyToOne(fetch = FetchType.LAZY)
    private  Driver driver;
    @ManyToOne
    private Passenger passenger;
}
