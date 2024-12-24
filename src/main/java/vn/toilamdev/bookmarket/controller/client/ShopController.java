package vn.toilamdev.bookmarket.controller.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.toilamdev.bookmarket.domain.Book;
import vn.toilamdev.bookmarket.domain.Book_;
import vn.toilamdev.bookmarket.domain.Category;
import vn.toilamdev.bookmarket.service.BookService;
import vn.toilamdev.bookmarket.service.CategoryService;

@Controller
@RequestMapping("/shop")
public class ShopController {
    private final BookService bookService;
    private final CategoryService categoryService;

    public ShopController(BookService bookService, CategoryService categoryService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String getShopPage(Model model, @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) String keyword) {

        int currentPage = page;
        int bookCount = 0;
        int totalPages = 1;
        int limit = 1;

        Pageable pageable = PageRequest.of(currentPage - 1, limit, Sort.by(Direction.ASC, Book_.TITLE));
        List<Book> books = new ArrayList<>();
        List<Category> categories = this.categoryService.getAllCategories();

        // Update book count
        if (keyword != null) {
            books = this.bookService.getListBooksWithTitle(keyword, pageable);
            bookCount = this.bookService.getBookCountWithTitle(keyword);
            model.addAttribute("keyword", keyword);
        } else {
            books = this.bookService.getAllBooks(pageable);
            bookCount = this.bookService.getAllBooks().size();
        }

        // Update total pages
        if (bookCount % limit != 0) {
            totalPages = bookCount / limit + 1;
        } else {
            totalPages = bookCount / limit;
        }

        model.addAttribute("books", books);
        model.addAttribute("categories", categories);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);

        return "client/homepage/homepage-shop";
    }

    @GetMapping("/{id}")
    public String getDetailPage(Model model, @PathVariable("id") long id) {

        Book currentBook = this.bookService.getBookById(id);

        model.addAttribute("currentBook", currentBook);

        return "client/homepage/homepage-shop-detail";
    }
}
