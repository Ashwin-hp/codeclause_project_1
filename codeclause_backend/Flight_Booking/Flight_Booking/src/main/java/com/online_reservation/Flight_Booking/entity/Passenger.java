package com.online_reservation.Flight_Booking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("Passenger")
public class Passenger {
    private Long Passenger_id;
    private int Flight_id;
    private String Name;
    private int Age;
    private int seatnum;


}
