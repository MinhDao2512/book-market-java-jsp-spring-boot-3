package vn.toilamdev.bookmarket.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        int limit = 1;
        long bookCount = 0;
        long totalPages = 0;

        Map<String, Object> response = new HashMap<>();

        boolean hasFilters = bookCriteriaDTO.getKeyword().filter(k -> !k.isEmpty()).isPresent()
                || bookCriteriaDTO.getCategories().isPresent()
                || bookCriteriaDTO.getPrices().isPresent() || bookCriteriaDTO.getStates().isPresent();

        Pageable pageable = PageRequest.of(currentPage - 1, limit);
        List<Book> books;

        // Update books & bookCount
        if (!hasFilters) {
            books = this.bookService.fetchAllBooks(pageable, bookCriteriaDTO.getSortBy().get());
            bookCount = this.bookService.getAllBooks().size();
        } else {
            books = this.bookService.fetchBooksWithFilter(bookCriteriaDTO, pageable);
            bookCount = this.bookService.countBooksWithFilter(bookCriteriaDTO);
        }

        // Update Total Pages
        if (bookCount % limit != 0) {
            totalPages = bookCount / limit + 1;
        } else {
            totalPages = bookCount / limit;
        }

        response.put("data", books);
        response.put("totalPages", totalPages);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
