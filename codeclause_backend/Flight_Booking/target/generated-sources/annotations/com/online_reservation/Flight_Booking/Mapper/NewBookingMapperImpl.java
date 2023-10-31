package com.online_reservation.Flight_Booking.Mapper;

import com.online_reservation.Flight_Booking.DTO.NewBookingDTO;
import com.online_reservation.Flight_Booking.entity.NewBooking;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-11T16:13:44+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
public class NewBookingMapperImpl implements NewBookingMapper {

    @Override
    public NewBooking mapNewBookingDTOToNewBooking(NewBookingDTO NewBookingDTO) {
        if ( NewBookingDTO == null ) {
            return null;
        }

        NewBooking newBooking = new NewBooking();

        newBooking.setBookingId( NewBookingDTO.getBookingId() );
        List<PassengerDTO> list = NewBookingDTO.getPassengerList();
        if ( list != null ) {
            newBooking.setPassengerList( new ArrayList<PassengerDTO>( list ) );
        }
        newBooking.setFlightDataDTO( NewBookingDTO.getFlightDataDTO() );
        newBooking.setUserDTO( NewBookingDTO.getUserDTO() );

        return newBooking;
    }

    @Override
    public NewBookingDTO mapNewBookingToNewBookingDTO(NewBooking NewBooking) {
        if ( NewBooking == null ) {
            return null;
        }

        NewBookingDTO newBookingDTO = new NewBookingDTO();

        newBookingDTO.setBookingId( NewBooking.getBookingId() );
        List<PassengerDTO> list = NewBooking.getPassengerList();
        if ( list != null ) {
            newBookingDTO.setPassengerList( new ArrayList<PassengerDTO>( list ) );
        }
        newBookingDTO.setFlightDataDTO( NewBooking.getFlightDataDTO() );
        newBookingDTO.setUserDTO( NewBooking.getUserDTO() );

        return newBookingDTO;
    }
}
