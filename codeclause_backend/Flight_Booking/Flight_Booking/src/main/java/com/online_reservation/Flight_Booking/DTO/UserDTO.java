package com.online_reservation.Flight_Booking.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private int userid;
    private String username;
    private String userpassword;
    private String address;
    private String city;
}

