package vn.toilamdev.bookmarket.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import vn.toilamdev.bookmarket.validation.validator.UniqueAuthorValidator;

@Constraint(validatedBy = UniqueAuthorValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UniqueAuthor {
    String message() default "The author already exists. Please enter a different the author !";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
