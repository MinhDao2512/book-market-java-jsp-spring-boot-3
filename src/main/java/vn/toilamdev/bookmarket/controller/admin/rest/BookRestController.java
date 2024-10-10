package vn.toilamdev.bookmarket.controller.admin.rest;

import java.util.Date;
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

import vn.toilamdev.bookmarket.domain.Author;
import vn.toilamdev.bookmarket.domain.Book;
import vn.toilamdev.bookmarket.domain.Publisher;
import vn.toilamdev.bookmarket.dto.BookDTO;
import vn.toilamdev.bookmarket.mapper.BookMapper;
import vn.toilamdev.bookmarket.service.AuthorService;
import vn.toilamdev.bookmarket.service.BookService;
import vn.toilamdev.bookmarket.service.PublisherService;

@RestController
@RequestMapping("/api/admin")
public class BookRestController {

    private final PublisherService publisherService;
    private final AuthorService authorService;
    private final BookService bookService;

    public BookRestController(PublisherService publisherService, AuthorService authorService, BookService bookService) {
        this.publisherService = publisherService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@ModelAttribute BookDTO bookDTO,
            @RequestParam("bookFiles") List<MultipartFile> bookFiles) {

        Publisher publisher = this.publisherService.getPublisherByName(bookDTO.getPublisher());
        Book newBook = new Book();
        newBook = BookMapper.mappingBookDTO(newBook, bookDTO);

        if (bookDTO.getAuthorDefault().equals("OTHER")) {
            Author newAuthor = bookDTO.getNewAuthor();
            newAuthor.setCreatedAt(new Date(System.currentTimeMillis()));
            newAuthor = this.authorService.saveOrUpdate(newAuthor);

            newBook.setAuthor(newAuthor);
        } else {
            Author newAuthor = this.authorService.getAuthorByName(bookDTO.getAuthorDefault());
            newBook.setAuthor(newAuthor);
        }

        newBook.setPublisher(publisher);
        newBook.setCreatedAt(new Date(System.currentTimeMillis()));
        // Save Book
        newBook = this.bookService.saveOrUpdateBook(newBook);
        // Save BookImage
        this.bookService.handleSaveBookImage(bookFiles, newBook);
        // Save Category
        this.bookService.handleSaveBookCategorization(bookDTO.getCategories(), newBook);

        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Void> updateBook(@ModelAttribute BookDTO bookDTO, @PathVariable long id,
            @RequestParam("bookFiles") List<MultipartFile> booFiles) {

        Book currentBook = this.bookService.getBookById(id);
        currentBook = BookMapper.mappingBookDTO(currentBook, bookDTO);

        if (booFiles != null && booFiles.get(0).getOriginalFilename() != "") {
            currentBook.setBookImages(this.bookService.handleUpdateBookImage(booFiles, currentBook));
        }

        this.bookService.saveOrUpdateBook(currentBook);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable long id) {
        Book currentBook = this.bookService.getBookById(id);
        this.bookService.handleDeleteBook(currentBook);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
