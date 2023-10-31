package com.online_reservation.Flight_search.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "FlightData")
public class FlightData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String Airlines;
    public String Flight_num;
    public String departure_location;
    public String arrival_location;
    public String departure_time;
    public String arrival_time;
    public String flight_date;
    public int Flight_charge;
}
