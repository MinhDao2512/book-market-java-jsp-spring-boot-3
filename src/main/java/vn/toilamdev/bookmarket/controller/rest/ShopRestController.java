package vn.toilamdev.bookmarket.controller.rest;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.toilamdev.bookmarket.domain.Book;
import vn.toilamdev.bookmarket.domain.Book_;
import vn.toilamdev.bookmarket.dto.BookCriteriaDTO;
import vn.toilamdev.bookmarket.service.BookService;

@RestController
@RequestMapping("/shop/search")
public class ShopRestController {

    private final BookService bookService;

    public ShopRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<Object> fetchBookByFilter(BookCriteriaDTO bookCriteriaDTO) {
        int currentPage = Integer.parseInt(bookCriteriaDTO.getPage().get());
        int limit = 1;

        Pageable pageable = PageRequest.of(currentPage - 1, limit, Sort.by(Direction.ASC, Book_.TITLE));
        List<Book> book = this.bookService.getAllBooks(pageable);

        return ResponseEntity.status(HttpStatus.OK).body(book);
    }
}
