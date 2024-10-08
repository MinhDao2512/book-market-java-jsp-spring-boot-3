package vn.toilamdev.bookmarket.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.toilamdev.bookmarket.domain.Author;
import vn.toilamdev.bookmarket.domain.Book;
import vn.toilamdev.bookmarket.domain.Category;
import vn.toilamdev.bookmarket.domain.Publisher;
import vn.toilamdev.bookmarket.domain.Role;
import vn.toilamdev.bookmarket.domain.User;
import vn.toilamdev.bookmarket.service.AuthorService;
import vn.toilamdev.bookmarket.service.BookService;
import vn.toilamdev.bookmarket.service.CategoryService;
import vn.toilamdev.bookmarket.service.PublisherService;
import vn.toilamdev.bookmarket.service.RoleService;
import vn.toilamdev.bookmarket.service.UserService;

@Controller
@RequestMapping("/admin")
public class DashboardController {

    private final RoleService roleService;
    private final UserService userService;
    private final BookService bookService;
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final PublisherService publisherService;

    public DashboardController(RoleService roleService, UserService userService, BookService bookService,
            CategoryService categoryService, AuthorService authorService, PublisherService publisherService) {
        this.roleService = roleService;
        this.userService = userService;
        this.bookService = bookService;
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.publisherService = publisherService;
    }

    @GetMapping
    public String getDashboardPage(Model model) {
        return "admin/dashboard/dashboard-home";
    }

    @GetMapping("/authors")
    public String getAuthorsTablePage(Model model) {
        List<Author> authors = this.authorService.getAllAuthors();
        model.addAttribute("authors", authors);
        return "admin/author/author-table";
    }

    @GetMapping("/books")
    public String getBooksTablePage(Model model) {
        List<Book> books = this.bookService.getAllBooks();
        model.addAttribute("books", books);
        return "admin/book/book-table";
    }

    @GetMapping("/categories")
    public String getCategoriesTablePage(Model model) {
        List<Category> categories = this.categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "admin/category/category-table";
    }

    @GetMapping("/orders")
    public String getOrdersTablePage(Model model) {
        return "admin/order/order-table";
    }

    @GetMapping("/publishers")
    public String getPublishersTablePage(Model model) {
        List<Publisher> publishers = this.publisherService.getAllPublishers();
        model.addAttribute("publishers", publishers);
        return "admin/publisher/publisher-table";
    }

    @GetMapping("/roles")
    public String getRolesTablePage(Model model) {
        List<Role> roles = this.roleService.getAllRoles();
        model.addAttribute("roles", roles);
        return "admin/role/role-table";
    }

    @GetMapping("/users")
    public String getUsersTablePage(Model model) {
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/user/user-table";
    }
}
