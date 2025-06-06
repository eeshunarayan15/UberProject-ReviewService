package com.eeshu.uberreviewservice.repository;

import com.eeshu.uberreviewservice.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
