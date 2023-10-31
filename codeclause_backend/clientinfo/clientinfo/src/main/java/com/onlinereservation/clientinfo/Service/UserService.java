package com.onlinereservation.clientinfo.Service;

import com.onlinereservation.clientinfo.DTO.UserDTO;
import com.onlinereservation.clientinfo.Entity.User;
import com.onlinereservation.clientinfo.Mapper.UserMapper;
import com.onlinereservation.clientinfo.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public UserDTO addUser(UserDTO userDTO) {
        User savedUser = userRepo.save(UserMapper.INSTANCE.UserDTOToUser(userDTO));
        return UserMapper.INSTANCE.UserToUserDTO(savedUser);
    }



    public ResponseEntity<UserDTO> fetchUserDetailsById(Long userId) {
        Optional<User> fetchedUser = userRepo.findById(userId);
        if(fetchedUser.isPresent()){
            return new ResponseEntity<>(UserMapper.INSTANCE.UserToUserDTO(fetchedUser.get()), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
   public ResponseEntity<UserDTO> fetchUserDetails(String username, String userpassword) {
       Optional<User> fetchedUser = userRepo.findUser(username, userpassword);
       if(fetchedUser.isPresent()){
           return new ResponseEntity<>(UserMapper.INSTANCE.UserToUserDTO(fetchedUser.get()), HttpStatus.OK);
       }
       else{
           return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
       }
    }

}

