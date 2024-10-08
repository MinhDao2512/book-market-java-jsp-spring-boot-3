package vn.toilamdev.bookmarket.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.toilamdev.bookmarket.domain.Author;
import vn.toilamdev.bookmarket.domain.Category;
import vn.toilamdev.bookmarket.domain.Publisher;
import vn.toilamdev.bookmarket.service.AuthorService;
import vn.toilamdev.bookmarket.service.CategoryService;
import vn.toilamdev.bookmarket.service.PublisherService;

@Controller
@RequestMapping("/admin/books")
public class BookController {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final PublisherService publisherService;

    public BookController(CategoryService categoryService, AuthorService authorService,
            PublisherService publisherService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.publisherService = publisherService;
    }

    @GetMapping("/create")
    public String getCreateBookPage(Model model) {
        List<Category> categories = this.categoryService.getAllCategories();
        List<Author> authors = this.authorService.getAllAuthors();
        List<Publisher> publishers = this.publisherService.getAllPublishers();

        model.addAttribute("authors", authors);
        model.addAttribute("categories", categories);
        model.addAttribute("publishers", publishers);
        return "admin/book/book-create";
    }
}
