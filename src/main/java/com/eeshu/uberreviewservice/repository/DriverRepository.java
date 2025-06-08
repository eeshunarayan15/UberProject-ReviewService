package com.eeshu.uberreviewservice.repository;

import com.eeshu.uberreviewservice.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver,Long> {

    Optional<Driver> findByIdAndLicenseNumber(Long id,String licenseNumber);
//    @Query(nativeQuery = true,value = "SELECT * FROM Driver WHERE id=:id AND license_Number=:licenseNumber");
//    Optional<Driver> rawFindByIdAndLicenseNumber(Long id,String licenseNumber);
@Query(nativeQuery = true, value = "SELECT * FROM Driver WHERE id=:id AND license_Number=:licenseNumber")
Optional<Driver> rawFindByIdAndLicenseNumber(@Param("id") Long id, @Param("licenseNumber") String licenseNumber);


List<Driver>findAllByIdIn(List<Long> driverId);
}
