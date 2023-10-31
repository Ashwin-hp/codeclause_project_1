package com.online_reservation.Flight_search.controller;

import com.online_reservation.Flight_search.DTO.FlightDataDTO;
import com.online_reservation.Flight_search.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/Search")
public class flightserachController {
    @Autowired
    public FlightService flightService;

    @GetMapping("/allFlights")
    public ResponseEntity<List<FlightDataDTO>> getAllFlights(){
        List<FlightDataDTO> allFlights=flightService.findAllFlights();
        return new ResponseEntity<>(allFlights, HttpStatus.OK);
    }

    @GetMapping("/allFlightsWithlocation")
    public ResponseEntity<List<FlightDataDTO>> getAllFlightswithselectedlocation(@RequestParam String departure_location, @RequestParam String arrival_location, @RequestParam String flight_date){
        List<FlightDataDTO> allFlightsWithLocation=flightService.findAllFlightsWithLocation(departure_location,arrival_location,flight_date);
        return new ResponseEntity<>(allFlightsWithLocation, HttpStatus.OK);

    }
        //For Admin
        //
        @PostMapping("/addFlight")
        public ResponseEntity<FlightDataDTO> saveFlight(@RequestBody FlightDataDTO FlightDataDTO) {
            FlightDataDTO flightAdded = flightService.addFlightInDB(FlightDataDTO);
        return new ResponseEntity<>(flightAdded, HttpStatus.CREATED);
    }

    @GetMapping("fetchById/{id}")
    public ResponseEntity<FlightDataDTO> findFlightById(@PathVariable Long id) {
        return flightService.findFlightById(id);
    }

}
