package vn.toilamdev.bookmarket.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.toilamdev.bookmarket.domain.Author;
import vn.toilamdev.bookmarket.domain.Book;
import vn.toilamdev.bookmarket.domain.Category;
import vn.toilamdev.bookmarket.domain.Publisher;
import vn.toilamdev.bookmarket.service.AuthorService;
import vn.toilamdev.bookmarket.service.BookService;
import vn.toilamdev.bookmarket.service.CategoryService;
import vn.toilamdev.bookmarket.service.PublisherService;

@Controller
@RequestMapping("/admin/books")
public class BookController {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final PublisherService publisherService;
    private final BookService bookService;

    public BookController(CategoryService categoryService, AuthorService authorService,
            PublisherService publisherService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.publisherService = publisherService;
        this.bookService = bookService;
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

    @GetMapping("/detail/{id}")
    public String getDetailBookPage(Model model, @PathVariable long id) {
        Book currentBook = this.bookService.getBookById(id);
        model.addAttribute("currentBook", currentBook);
        return "admin/book/book-detail";
    }

    @GetMapping("/update/{id}")
    public String getUpdateBookPage(Model model, @PathVariable long id) {
        Book currentBook = this.bookService.getBookById(id);
        List<Category> categories = this.categoryService.getAllCategories();
        List<Author> authors = this.authorService.getAllAuthors();
        List<Publisher> publishers = this.publisherService.getAllPublishers();

        model.addAttribute("currentBook", currentBook);
        model.addAttribute("authors", authors);
        model.addAttribute("categories", categories);
        model.addAttribute("publishers", publishers);
        return "admin/book/book-update";
    }
}
