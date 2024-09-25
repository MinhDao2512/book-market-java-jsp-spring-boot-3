package vn.toilamdev.bookmarket.mapper;

import vn.toilamdev.bookmarket.domain.User;
import vn.toilamdev.bookmarket.dto.UserDTO;

public class UserMapper {

    public static User mappingUserDTO(UserDTO userDTO) {
        User user = new User();
        user.setFullName(userDTO.getLastName() + " " + userDTO.getFirstName());
        user.setEmail(userDTO.getEmail());
        user.setAddress(userDTO.getAddress());
        user.setDateOfBirth(userDTO.getDateOfBirth());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        return user;
    }
}
