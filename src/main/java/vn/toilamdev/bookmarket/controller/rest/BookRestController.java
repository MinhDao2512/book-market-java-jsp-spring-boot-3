package vn.toilamdev.bookmarket.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import vn.toilamdev.bookmarket.domain.Book;
import vn.toilamdev.bookmarket.dto.BookDTO;
import vn.toilamdev.bookmarket.service.BookService;

@RestController
@RequestMapping("/api/admin")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books")
    public ResponseEntity<?> createBook(@Valid @ModelAttribute BookDTO bookDTO, BindingResult bindingResult,
            @RequestParam("bookFiles") List<MultipartFile> bookFiles) {

        if (bindingResult.hasFieldErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                String fieldName = fieldError.getField();
                if (fieldName.equals("newAuthor.authorName")) {
                    fieldName = "authorName";
                }
                errors.put(fieldName, fieldError.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        this.bookService.handleCreateBook(bookDTO, bookFiles);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<?> updateBook(@ModelAttribute BookDTO bookDTO,
            @PathVariable long id,
            @RequestParam("bookFiles") List<MultipartFile> files) {

        Book currentBook = this.bookService.getBookById(id);
        if (currentBook != null) {
            this.bookService.handleUpdateBook(bookDTO, currentBook, files);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable long id) {

        Book currentBook = this.bookService.getBookById(id);
        this.bookService.handleDeleteBook(currentBook);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
