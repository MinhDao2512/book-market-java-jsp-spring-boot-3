package vn.toilamdev.bookmarket.mapper;

import vn.toilamdev.bookmarket.domain.User;
import vn.toilamdev.bookmarket.dto.UserDTO;

public class UserMapper {
    private static String formatName(String name) {
        String[] words = name.split(" ");
        String nameAfterFormat = "";
        for (String word : words) {
            word = word.toLowerCase();
            StringBuilder stringBuilder = new StringBuilder(word);
            stringBuilder.setCharAt(0, Character.toUpperCase(stringBuilder.charAt(0)));

            nameAfterFormat += stringBuilder.toString() + " ";
        }
        return nameAfterFormat;
    }

    public static User mappingUserDTO(UserDTO userDTO) {
        User user = new User();
        user.setFullName(formatName(userDTO.getLastName()) + formatName(userDTO.getFirstName()));
        user.setEmail(userDTO.getEmail());
        user.setAddress(userDTO.getHouseNumber() + " " + userDTO.getStreet() + ", " + userDTO.getWard() + ", "
                + userDTO.getDistrict() + ", " + userDTO.getCity());
        user.setDateOfBirth(userDTO.getDateOfBirth());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        return user;
    }
}
