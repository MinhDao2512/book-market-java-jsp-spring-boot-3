package vn.toilamdev.bookmarket.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.toilamdev.bookmarket.domain.Author;
import vn.toilamdev.bookmarket.service.AuthorService;

@Controller
@RequestMapping("/admin/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/create")
    public String getCreateAuthorPage() {
        return "admin/author/author-create";
    }

    @GetMapping("/detail/{id}")
    public String getDetailAuthorPage(Model model, @PathVariable long id) {
        Author currentAuthor = this.authorService.getAuthorById(id);
        model.addAttribute("currentAuthor", currentAuthor);
        return "admin/author/author-detail";
    }

    @GetMapping("/update/{id}")
    public String getUpdateAuthorPage(Model model, @PathVariable long id) {
        Author currentAuthor = this.authorService.getAuthorById(id);
        model.addAttribute("currentAuthor", currentAuthor);
        return "admin/author/author-update";
    }
}
