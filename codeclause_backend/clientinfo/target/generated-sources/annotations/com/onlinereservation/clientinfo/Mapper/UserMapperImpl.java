package com.onlinereservation.clientinfo.Mapper;

import com.onlinereservation.clientinfo.DTO.UserDTO;
import com.onlinereservation.clientinfo.Entity.User;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-23T22:57:39+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User UserDTOToUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setUserid( userDTO.getUserid() );
        user.setUsername( userDTO.getUsername() );
        user.setUserpassword( userDTO.getUserpassword() );
        user.setAddress( userDTO.getAddress() );
        user.setCity( userDTO.getCity() );

        return user;
    }

    @Override
    public UserDTO UserToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setUserid( user.getUserid() );
        userDTO.setUsername( user.getUsername() );
        userDTO.setUserpassword( user.getUserpassword() );
        userDTO.setAddress( user.getAddress() );
        userDTO.setCity( user.getCity() );

        return userDTO;
    }
}
