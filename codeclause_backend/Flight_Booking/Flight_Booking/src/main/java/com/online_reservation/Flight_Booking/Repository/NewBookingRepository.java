package com.online_reservation.Flight_Booking.Repository;

import com.online_reservation.Flight_Booking.entity.NewBooking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NewBookingRepository  extends MongoRepository<NewBooking, Integer> {

    @Query("{ 'FlightDataDTO._id': ?0 }")
    List<NewBooking> findByflightdata(Long id);
}
