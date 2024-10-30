package vn.toilamdev.bookmarket.validation.validator;

import org.springframework.stereotype.Service;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import vn.toilamdev.bookmarket.domain.Author;
import vn.toilamdev.bookmarket.service.AuthorService;
import vn.toilamdev.bookmarket.validation.UniqueAuthor;

@Service
public class UniqueAuthorValidator implements ConstraintValidator<UniqueAuthor, Author> {

    private final AuthorService authorService;

    public UniqueAuthorValidator(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public boolean isValid(Author value, ConstraintValidatorContext context) {
        Boolean uniqueAuthor = authorService.existsAuthor(value.getName(), value.getNationality(),
                value.getBirthDate());
        if (uniqueAuthor) {
            context.buildConstraintViolationWithTemplate("Thông tin của 'Tác Giả' đã tồn tại")
                    .addPropertyNode("authorName")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            return false;
        }
        return true;
    }

}
