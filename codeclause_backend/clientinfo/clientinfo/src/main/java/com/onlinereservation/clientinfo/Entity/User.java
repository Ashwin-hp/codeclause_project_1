package com.onlinereservation.clientinfo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long userid;

    public String username;
    public String userpassword;
    public String address;
    public String city;
}

