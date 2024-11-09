package vn.toilamdev.bookmarket.controller.client;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.toilamdev.bookmarket.domain.Book;
import vn.toilamdev.bookmarket.service.BookService;

@Controller
@RequestMapping("/")
public class HomeController {
    private final BookService bookService;

    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String getHomePage(Model model) {
        List<Book> books = this.bookService.getAllBooks();

        model.addAttribute("books", books);

        return "client/homepage/homepage-home";
    }

    @GetMapping("access-deny")
    public String getDenyPage(Model model) {
        return "errors/403";
    }
}
