package com.online_reservation.Flight_Booking.Mapper;

import com.online_reservation.Flight_Booking.DTO.NewBookingDTO;
import com.online_reservation.Flight_Booking.entity.NewBooking;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NewBookingMapper {
    NewBookingMapper INSTANCE = Mappers.getMapper(NewBookingMapper.class);

    NewBooking mapNewBookingDTOToNewBooking(NewBookingDTO NewBookingDTO);
    NewBookingDTO mapNewBookingToNewBookingDTO(NewBooking NewBooking);
}
