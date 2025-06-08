package com.eeshu.uberreviewservice.controller;

import com.eeshu.uberreviewservice.dto.DriverRequest;
import com.eeshu.uberreviewservice.model.Booking;
import com.eeshu.uberreviewservice.model.Driver;
import com.eeshu.uberreviewservice.repository.BookingRepository;
import com.eeshu.uberreviewservice.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class TestController {
    private  final DriverRepository driverRepository;
    private  final BookingRepository bookingRepository;
    @GetMapping("")
    public ResponseEntity<?> test(){
        Optional<Booking> savedBooking = bookingRepository.findById(1L);
        if(savedBooking.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(savedBooking.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking not found");
        }

    }
    @GetMapping("/driver/{id}/{licenseNumber}")
    public ResponseEntity<?> test(@PathVariable Long id,@PathVariable String licenseNumber){
        System.out.println(id +"id");
        Optional<Driver> savedDriver = driverRepository.rawFindByIdAndLicenseNumber(id,licenseNumber);
        if(savedDriver.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(savedDriver.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Driver not found");
        }

    }
    @GetMapping("/driver/all")
    public ResponseEntity<?> getAllDrivers(){

        List<Driver> all = driverRepository.findAll();
        if(!all.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(all);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Driver not found");
        }

    }
    @GetMapping("/getallbooking/")
    public ResponseEntity<?> getDriverBooking( @RequestBody DriverRequest driverRequest){

        List<Driver> allByIdIn = driverRepository.findAllByIdIn(driverRequest.getDriverIds());
        // Let's examine exactly what we're getting before we return it
        System.out.println("Number of drivers found: " + allByIdIn.size());

        for (Driver driver : allByIdIn) {
            System.out.println("Driver: " + driver.getName());
            System.out.println("Number of bookings: " + driver.getBookings().size());

            // This line might trigger the N+1 problem or lazy loading issues
            for (Booking booking : driver.getBookings()) {
                System.out.println("  Booking ID: "  + ", Status: " + booking.getBookingStatus());
            }
        }

//        driverRepository.=-
        if(!allByIdIn.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(allByIdIn);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Driver not found");
        }
    }


}
