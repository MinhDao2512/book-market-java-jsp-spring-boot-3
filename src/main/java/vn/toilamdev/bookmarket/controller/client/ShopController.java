package vn.toilamdev.bookmarket.controller.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.toilamdev.bookmarket.constant.SystemConstant;
import vn.toilamdev.bookmarket.domain.Book;
import vn.toilamdev.bookmarket.domain.Category;
import vn.toilamdev.bookmarket.service.BookService;
import vn.toilamdev.bookmarket.service.CategoryService;
import vn.toilamdev.bookmarket.utils.PaginationUtils;

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
    public String getShopPage(Model model, @RequestParam("page") Optional<Integer> page,
            @RequestParam("title") Optional<String> title) {

        int currentPage = 1;

        if (page.isPresent()) {
            currentPage = page.get();
        }

        int bookCount = this.bookService.getAllBooks().size();
        int totalPages = 1;
        int limit = SystemConstant.LIMIT;
        int maxVisiblePages = SystemConstant.MAX_VISIBLE_PAGES;

        Pageable pageable = PageRequest.of(currentPage - 1, limit);
        List<Book> books = new ArrayList<>();
        if (title.isPresent()) {
            books = this.bookService.getListBooksWithTitle(title.get(), pageable);
        } else {
            books = this.bookService.getAllBooks(pageable);
        }

        List<Category> categories = this.categoryService.getAllCategories();

        if (bookCount % limit != 0) {
            totalPages = bookCount / limit + 1;
        } else {
            totalPages = bookCount / limit;
        }

        List<Integer> pageNumbers = PaginationUtils.getPageNumbers(currentPage, totalPages, maxVisiblePages);
        model.addAttribute("books", books);
        model.addAttribute("categories", categories);
        model.addAttribute("pageNumbers", pageNumbers);
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
