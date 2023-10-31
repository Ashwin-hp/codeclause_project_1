package com.online_reservation.Flight_Booking.Service;
import com.online_reservation.Flight_Booking.DTO.PassengerDTO;
import com.online_reservation.Flight_Booking.DTO.FlightDataDTO;
import com.online_reservation.Flight_Booking.DTO.NewBookingDTO;
import com.online_reservation.Flight_Booking.DTO.NewBookingDTOfromFE;
import com.online_reservation.Flight_Booking.DTO.UserDTO;
import com.online_reservation.Flight_Booking.Mapper.NewBookingMapper;
import com.online_reservation.Flight_Booking.Repository.NewBookingRepository;
import com.online_reservation.Flight_Booking.entity.NewBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingService {

@Autowired
SequenceGenerator sequenceGenerator;
@Autowired
NewBookingRepository newBookingRepo;

    @Autowired
    RestTemplate restTemplate;
    public NewBookingDTO saveOrderInDB(NewBookingDTOfromFE BookingDetails) {

        Integer newOrderID = sequenceGenerator.generateNextOrderId();
        UserDTO userDTO =fetchUserDetailsFromUserId(BookingDetails.getUserid());
        FlightDataDTO FlightdataDTO=fetchFlightDetailsFromId(BookingDetails.getId());
        NewBooking NewBookingToBeSaved = new NewBooking(newOrderID, BookingDetails.getPassengerList(), FlightdataDTO, userDTO );
        newBookingRepo.save(NewBookingToBeSaved);
        return NewBookingMapper.INSTANCE.mapNewBookingToNewBookingDTO(NewBookingToBeSaved);
    }

    private UserDTO fetchUserDetailsFromUserId(Integer userid) {
        return restTemplate.getForObject("http://USER-SERVICE-NEW/user/fetchUserById/" + userid, UserDTO.class);
    }

    private FlightDataDTO fetchFlightDetailsFromId(Integer id) {
        return restTemplate.getForObject("http://Flight-Search/Search/fetchById/" + id, FlightDataDTO.class);
    }

    public List<NewBookingDTO> findByFlightId(Long id) {
        List<NewBooking> FlightDatabyId =newBookingRepo.findByflightdata(id);
        List<NewBookingDTO> FlightDatabyIdDTO = FlightDatabyId.stream().map(NewBookingMapper.INSTANCE::mapNewBookingToNewBookingDTO).collect(Collectors.toList());
        return FlightDatabyIdDTO;
    }
}
