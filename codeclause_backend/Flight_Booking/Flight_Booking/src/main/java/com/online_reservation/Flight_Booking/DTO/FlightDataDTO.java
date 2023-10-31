package com.online_reservation.Flight_Booking.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDataDTO {
    public Long id;
    public String Flight_num;
    public String departure_location;
    public String arrival_location;
    public String departure_time;
    public String arrival_time;
}
