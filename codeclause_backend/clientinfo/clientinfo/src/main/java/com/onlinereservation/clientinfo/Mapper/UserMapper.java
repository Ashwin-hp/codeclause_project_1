package com.onlinereservation.clientinfo.Mapper;
import com.onlinereservation.clientinfo.DTO.UserDTO;
import com.onlinereservation.clientinfo.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User UserDTOToUser(UserDTO userDTO);
    UserDTO UserToUserDTO(User user);
}
