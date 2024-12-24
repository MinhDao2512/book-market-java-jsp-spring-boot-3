package vn.toilamdev.bookmarket.controller.rest;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.toilamdev.bookmarket.domain.Book;
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
        int limit = 3;

        if (!bookCriteriaDTO.getKeyword().isPresent() && !bookCriteriaDTO.getPrices().isPresent()
                && !bookCriteriaDTO.getStates().isPresent() && !bookCriteriaDTO.getCategories().isPresent()) {
            Pageable pageable = PageRequest.of(currentPage - 1, limit);
            List<Book> book = this.bookService.fetchBooksWithFilter(bookCriteriaDTO, pageable);

            return ResponseEntity.status(HttpStatus.OK).body(book);
        } else {
            Pageable pageable = PageRequest.of(currentPage - 1, limit);
            List<Book> book = this.bookService.fetchBooksWithFilter(bookCriteriaDTO, pageable);

            return ResponseEntity.status(HttpStatus.OK).body(book);
        }
    }
}
