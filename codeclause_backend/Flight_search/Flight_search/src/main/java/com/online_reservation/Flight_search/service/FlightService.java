package com.online_reservation.Flight_search.service;

import com.online_reservation.Flight_search.DTO.FlightDataDTO;
import com.online_reservation.Flight_search.Mapper.FlightDataMapper;
import com.online_reservation.Flight_search.pojo.FlightData;
import com.online_reservation.Flight_search.repository.FlightDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightService {
    @Autowired
    public FlightDataRepository FlightDataRepo;

    public List<FlightDataDTO> findAllFlights() {
        List<FlightData> FlightData=FlightDataRepo.findAll();
        List<FlightDataDTO> FlightDataDTOList = FlightData.stream().map(FlightDataMapper.INSTANCE::FlightDataToFlightDataDTO).collect(Collectors.toList());
        return FlightDataDTOList;


    }

    public List<FlightDataDTO> findAllFlightsWithLocation(String departureLocation, String arrivalLocation, String flight_date) {

        List<FlightData> FlightData=FlightDataRepo.findAllwithselectedlocation(departureLocation,arrivalLocation,flight_date);
        List<FlightDataDTO> FlightDataWithLocation = FlightData.stream().map(FlightDataMapper.INSTANCE::FlightDataToFlightDataDTO).collect(Collectors.toList());
        return FlightDataWithLocation;

    }

    public FlightDataDTO addFlightInDB(FlightDataDTO flightDataDTO) {
        FlightData savedFlight= FlightDataRepo.save(FlightDataMapper.INSTANCE.FlightDataDTOToFlightData(flightDataDTO));
        return FlightDataMapper.INSTANCE.FlightDataToFlightDataDTO(savedFlight);
    }

    public ResponseEntity<FlightDataDTO> findFlightById(Long id) {
        Optional<FlightData> FlightData =  FlightDataRepo.findById(id);
        if(FlightData.isPresent()){
            return new ResponseEntity<>(FlightDataMapper.INSTANCE.FlightDataToFlightDataDTO(FlightData.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }





}

