package com.eeshu.uberreviewservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Driver extends BaseModel {
    private String name;
    @Column(nullable = false, unique = true)
    private String licenseNumber;
    //1:n Driver :Booking driver has many booking
    @OneToMany(mappedBy = "driver")
    private List<Booking> bookings=new ArrayList<>();

}
