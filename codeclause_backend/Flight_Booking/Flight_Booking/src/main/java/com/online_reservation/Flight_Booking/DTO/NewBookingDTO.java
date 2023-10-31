package com.online_reservation.Flight_Booking.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewBookingDTO {

    private Integer bookingId;
    private List<PassengerDTO> PassengerList;
    private FlightDataDTO FlightDataDTO;
    private UserDTO userDTO;
}
