package com.online_reservation.Flight_Booking.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerDTO {

    private String name;
    private int age;
    private int seatnum;
}
