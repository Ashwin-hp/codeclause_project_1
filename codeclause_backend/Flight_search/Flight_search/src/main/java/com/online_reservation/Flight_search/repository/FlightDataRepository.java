package com.online_reservation.Flight_search.repository;

import com.online_reservation.Flight_search.pojo.FlightData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightDataRepository extends JpaRepository<FlightData,Long> {
    @Query("from FlightData where departure_location = ?1 and arrival_location=?2 and flight_date=?3")
    List<FlightData> findAllwithselectedlocation(String departure_location, String arrival_location, String flight_date);
}
