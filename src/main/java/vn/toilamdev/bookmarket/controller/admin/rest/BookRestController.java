package vn.toilamdev.bookmarket.controller.admin.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
    public ResponseEntity<Book> createBook(@ModelAttribute BookDTO bookDTO,
            @RequestParam("bookFiles") List<MultipartFile> bookFiles) {

        this.bookService.handleCreateBook(bookDTO, bookFiles);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Void> updateBook(@ModelAttribute BookDTO bookDTO, @PathVariable long id,
            @RequestParam("bookFiles") List<MultipartFile> files) {

        Book currentBook = this.bookService.getBookById(id);
        this.bookService.handleUpdateBook(bookDTO, currentBook, files);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable long id) {

        Book currentBook = this.bookService.getBookById(id);
        this.bookService.handleDeleteBook(currentBook);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
