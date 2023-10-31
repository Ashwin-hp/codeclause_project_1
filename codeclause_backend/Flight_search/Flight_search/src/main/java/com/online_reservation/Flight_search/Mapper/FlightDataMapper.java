package com.online_reservation.Flight_search.Mapper;

import com.online_reservation.Flight_search.DTO.FlightDataDTO;
import com.online_reservation.Flight_search.pojo.FlightData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FlightDataMapper {
   FlightDataMapper INSTANCE = Mappers.getMapper(FlightDataMapper.class);

    FlightData FlightDataDTOToFlightData(FlightDataDTO flightdataDTO);

    FlightDataDTO FlightDataToFlightDataDTO(FlightData flightdata);
}
