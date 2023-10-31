package com.online_reservation.Flight_search.Mapper;

import com.online_reservation.Flight_search.DTO.FlightDataDTO;
import com.online_reservation.Flight_search.pojo.FlightData;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-28T23:45:15+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
public class FlightDataMapperImpl implements FlightDataMapper {

    @Override
    public FlightData FlightDataDTOToFlightData(FlightDataDTO flightdataDTO) {
        if ( flightdataDTO == null ) {
            return null;
        }

        FlightData flightData = new FlightData();

        flightData.setId( flightdataDTO.getId() );
        flightData.setAirlines( flightdataDTO.getAirlines() );
        flightData.setFlight_num( flightdataDTO.getFlight_num() );
        flightData.setDeparture_location( flightdataDTO.getDeparture_location() );
        flightData.setArrival_location( flightdataDTO.getArrival_location() );
        flightData.setDeparture_time( flightdataDTO.getDeparture_time() );
        flightData.setArrival_time( flightdataDTO.getArrival_time() );
        flightData.setFlight_date( flightdataDTO.getFlight_date() );
        flightData.setFlight_charge( flightdataDTO.getFlight_charge() );
        flightData.Airlines = flightdataDTO.Airlines;
        flightData.Flight_num = flightdataDTO.Flight_num;
        flightData.Flight_charge = flightdataDTO.Flight_charge;

        return flightData;
    }

    @Override
    public FlightDataDTO FlightDataToFlightDataDTO(FlightData flightdata) {
        if ( flightdata == null ) {
            return null;
        }

        FlightDataDTO flightDataDTO = new FlightDataDTO();

        flightDataDTO.setId( flightdata.getId() );
        flightDataDTO.setAirlines( flightdata.getAirlines() );
        flightDataDTO.setFlight_num( flightdata.getFlight_num() );
        flightDataDTO.setDeparture_location( flightdata.getDeparture_location() );
        flightDataDTO.setArrival_location( flightdata.getArrival_location() );
        flightDataDTO.setDeparture_time( flightdata.getDeparture_time() );
        flightDataDTO.setArrival_time( flightdata.getArrival_time() );
        flightDataDTO.setFlight_date( flightdata.getFlight_date() );
        flightDataDTO.setFlight_charge( flightdata.getFlight_charge() );
        flightDataDTO.Airlines = flightdata.Airlines;
        flightDataDTO.Flight_num = flightdata.Flight_num;
        flightDataDTO.Flight_charge = flightdata.Flight_charge;

        return flightDataDTO;
    }
}
