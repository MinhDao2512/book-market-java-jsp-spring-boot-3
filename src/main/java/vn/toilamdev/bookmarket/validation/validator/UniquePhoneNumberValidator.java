package vn.toilamdev.bookmarket.validation.validator;

import org.springframework.stereotype.Service;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import vn.toilamdev.bookmarket.domain.User;
import vn.toilamdev.bookmarket.service.UserService;
import vn.toilamdev.bookmarket.validation.UniquePhoneNumber;

@Service
public class UniquePhoneNumberValidator implements ConstraintValidator<UniquePhoneNumber, String> {
    private final UserService userService;

    public UniquePhoneNumberValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        User currentUser = this.userService.getUserByPhoneNumber(value);
        return currentUser == null;
    }

}
