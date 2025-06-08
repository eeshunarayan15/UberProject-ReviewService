package com.eeshu.uberreviewservice.repository;

import com.eeshu.uberreviewservice.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
    List<Booking> findAllByDriver_Id(Long id);

    List<Booking> findAllByDriverIdIn(List<Long> driverIds);
}
