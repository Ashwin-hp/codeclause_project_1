package com.online_reservation.Flight_Booking.entity;

import com.online_reservation.Flight_Booking.DTO.FlightDataDTO;
import com.online_reservation.Flight_Booking.DTO.PassengerDTO;
import com.online_reservation.Flight_Booking.DTO.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("NewBooking")
public class NewBooking {
    private Integer bookingId;
    private List<PassengerDTO> PassengerList;
    private FlightDataDTO FlightDataDTO;
    private UserDTO userDTO;
}
