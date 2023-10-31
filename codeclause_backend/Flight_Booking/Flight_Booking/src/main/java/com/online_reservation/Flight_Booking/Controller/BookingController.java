package com.online_reservation.Flight_Booking.Controller;

import com.online_reservation.Flight_Booking.DTO.NewBookingDTO;
import com.online_reservation.Flight_Booking.DTO.NewBookingDTOfromFE;
import com.online_reservation.Flight_Booking.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/booking")
public class BookingController {
@Autowired
BookingService bookingService;
    @PostMapping("/saveBooking")
    public ResponseEntity<NewBookingDTO> saveOrder(@RequestBody NewBookingDTOfromFE BookingDetails){
        NewBookingDTO BookingSavedInDb = bookingService.saveOrderInDB(BookingDetails);
        return new ResponseEntity<>(BookingSavedInDb, HttpStatus.CREATED);
    }

    @GetMapping("/byFlightId/{id}")
    public List<NewBookingDTO> getFlightdataById(@PathVariable Long id) {
        List<NewBookingDTO> flightlist =bookingService.findByFlightId(id);
        return flightlist;
    }

}
