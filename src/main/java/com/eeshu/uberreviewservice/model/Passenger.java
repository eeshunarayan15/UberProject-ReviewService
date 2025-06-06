package com.eeshu.uberreviewservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "passenger")
public class Passenger  extends BaseModel{
    private String name;
    @OneToMany(mappedBy = "passenger")
    private List<Booking> bookings=new ArrayList<>();
}
