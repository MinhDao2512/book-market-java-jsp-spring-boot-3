package vn.toilamdev.bookmarket.validation.validator;

import org.springframework.stereotype.Service;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import vn.toilamdev.bookmarket.domain.User;
import vn.toilamdev.bookmarket.service.UserService;
import vn.toilamdev.bookmarket.validation.UniqueEmail;

@Service
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final UserService userService;

    public UniqueEmailValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        User currentUser = this.userService.getUserByEmail(value);
        return currentUser == null;
    }

}
