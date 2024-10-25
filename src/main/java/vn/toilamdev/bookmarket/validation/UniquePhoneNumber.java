package vn.toilamdev.bookmarket.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import vn.toilamdev.bookmarket.validation.validator.UniquePhoneNumberValidator;

@Constraint(validatedBy = UniquePhoneNumberValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UniquePhoneNumber {
    String message() default "'Phone Number' already exists. Please enter a different 'Phone Number' !";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
