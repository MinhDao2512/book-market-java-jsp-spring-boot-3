package vn.toilamdev.bookmarket.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.toilamdev.bookmarket.domain.Category;
import vn.toilamdev.bookmarket.service.CategoryService;

@Controller
@RequestMapping("/admin/books")
public class BookController {

    private final CategoryService categoryService;

    public BookController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/create")
    public String getCreateBookPage(Model model) {
        List<Category> categories = this.categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "admin/book/book-create";
    }
}
