package vn.toilamdev.bookmarket.controller.admin.rest;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import vn.toilamdev.bookmarket.domain.Author;
import vn.toilamdev.bookmarket.domain.Book;
import vn.toilamdev.bookmarket.service.AuthorService;
import vn.toilamdev.bookmarket.service.BookService;

@RestController
@RequestMapping("/api/admin")
public class AuthorRestController {
    private final AuthorService authorService;
    private final BookService bookService;

    public AuthorRestController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @PostMapping("/authors")
    public ResponseEntity<?> createAuthor(@Valid @ModelAttribute Author author, BindingResult bindingResult) {

        if (bindingResult.hasFieldErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        boolean existsAuthor = this.authorService.existsAuthor(author.getName(), author.getNationality(),
                author.getBirthDate());
        if (!existsAuthor) {
            author.setCreatedAt(new Date(System.currentTimeMillis()));
            this.authorService.saveOrUpdate(author);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @PutMapping("/authors/{id}")
    public ResponseEntity<?> updateAuthor(@Valid @ModelAttribute Author author, BindingResult bindingResult,
            @PathVariable long id) {

        if (bindingResult.hasFieldErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        Author currentAuthor = this.authorService.getAuthorById(id);
        if (currentAuthor != null) {
            currentAuthor.setName(author.getName());
            currentAuthor.setBiography(author.getBiography());
            currentAuthor.setBirthDate(author.getBirthDate());
            currentAuthor.setNationality(author.getNationality());
            currentAuthor.setUpdatedAt(new Date(System.currentTimeMillis()));

            this.authorService.saveOrUpdate(currentAuthor);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/authors/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable long id) {
        Author currentAuthor = this.authorService.getAuthorById(id);
        for (Book book : currentAuthor.getBooks()) {
            this.bookService.handleDeleteBook(book);
        }
        this.authorService.deleteAuthorById(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
