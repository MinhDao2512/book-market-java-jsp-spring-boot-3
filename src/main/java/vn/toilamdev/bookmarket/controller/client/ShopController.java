package vn.toilamdev.bookmarket.controller.client;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.toilamdev.bookmarket.domain.Book;
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
        List<Category> categories = this.categoryService.getAllCategories();

        model.addAttribute("categories", categories);
        model.addAttribute("keyword", keyword);

        return "client/homepage/homepage-shop";
    }

    @GetMapping("/{id}")
    public String getDetailPage(Model model, @PathVariable("id") long id) {

        Book currentBook = this.bookService.getBookById(id);

        model.addAttribute("currentBook", currentBook);

        return "client/homepage/homepage-shop-detail";
    }
}
