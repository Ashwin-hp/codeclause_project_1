package com.onlinereservation.clientinfo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {

    public Long userid;

    public String username;
    public String userpassword;
    public String address;
    public String city;
}

