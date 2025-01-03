package vn.toilamdev.bookmarket.controller.admin;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import vn.toilamdev.bookmarket.constant.SystemConstant;
import vn.toilamdev.bookmarket.domain.Author;
import vn.toilamdev.bookmarket.domain.Book;
import vn.toilamdev.bookmarket.domain.Category;
import vn.toilamdev.bookmarket.domain.Order;
import vn.toilamdev.bookmarket.domain.OrderItem;
import vn.toilamdev.bookmarket.domain.Publisher;
import vn.toilamdev.bookmarket.domain.Role;
import vn.toilamdev.bookmarket.domain.User;
import vn.toilamdev.bookmarket.service.AuthorService;
import vn.toilamdev.bookmarket.service.BookService;
import vn.toilamdev.bookmarket.service.CategoryService;
import vn.toilamdev.bookmarket.service.OrderItemService;
import vn.toilamdev.bookmarket.service.OrderService;
import vn.toilamdev.bookmarket.service.PublisherService;
import vn.toilamdev.bookmarket.service.RoleService;
import vn.toilamdev.bookmarket.service.UserService;
import vn.toilamdev.bookmarket.utils.PaginationUtils;

@Controller
@RequestMapping("/admin")
public class DashboardController {

    private final RoleService roleService;
    private final UserService userService;
    private final BookService bookService;
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final PublisherService publisherService;
    private final OrderService orderService;
    private final OrderItemService orderItemService;

    public DashboardController(RoleService roleService, UserService userService, BookService bookService,
            CategoryService categoryService, AuthorService authorService, PublisherService publisherService,
            OrderService orderService, OrderItemService orderItemService) {
        this.roleService = roleService;
        this.userService = userService;
        this.bookService = bookService;
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.publisherService = publisherService;
        this.orderService = orderService;
        this.orderItemService = orderItemService;
    }

    @GetMapping
    public String getDashboardPage(Model model) {
        model.addAttribute("countOrder", this.orderService.getCountOrder());
        return "admin/dashboard/dashboard-home";
    }

    @GetMapping("/authors")
    public String getAuthorsTablePage(Model model, @RequestParam("page") int page) {
        int authorCount = this.authorService.getAllAuthors().size();
        int totalPages = 1;
        int limit = SystemConstant.LIMIT;
        int maxVisible = SystemConstant.MAX_VISIBLE_PAGES;

        Pageable pageable = PageRequest.of(page - 1, limit);
        List<Author> authors = this.authorService.getAllAuthors(pageable);

        if (authorCount % limit != 0) {
            totalPages = authorCount / limit + 1;
        } else {
            totalPages = authorCount / limit;
        }
        List<Integer> pageNumbers = PaginationUtils.getPageNumbers(page, totalPages, maxVisible);

        model.addAttribute("authors", authors);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", page);
        model.addAttribute("pageNumbers", pageNumbers);
        return "admin/author/author-table";
    }

    @GetMapping("/books")
    public String getBooksTablePage(Model model, HttpServletRequest request, @RequestParam("page") int page) {
        HttpSession session = request.getSession();

        String roleName = (String) session.getAttribute("roleName");
        long userId = (long) session.getAttribute("id");
        User user = this.userService.getUserById(userId);

        if (roleName.equals("ADMIN") || roleName.equals("OWNER")) {
            int bookCount = this.bookService.getAllBooks().size();
            int totalPages = 1;
            int limit = SystemConstant.LIMIT;
            int maxVisible = SystemConstant.MAX_VISIBLE_PAGES;

            Pageable pageable = PageRequest.of(page - 1, limit);
            List<Book> books = this.bookService.getAllBooks(pageable);

            if (bookCount % limit != 0) {
                totalPages = bookCount / limit + 1;
            } else {
                totalPages = bookCount / limit;
            }
            List<Integer> pageNumbers = PaginationUtils.getPageNumbers(page, totalPages, maxVisible);

            model.addAttribute("books", books);
            model.addAttribute("totalPages", totalPages);
            model.addAttribute("currentPage", page);
            model.addAttribute("pageNumbers", pageNumbers);
        } else {
            int bookCount = this.bookService.getListBooksByCreatedBy(user.getEmail()).size();
            int totalPages = 1;
            int limit = SystemConstant.LIMIT;
            int maxVisible = SystemConstant.MAX_VISIBLE_PAGES;

            Pageable pageable = PageRequest.of(page - 1, limit);
            List<Book> books = this.bookService.getListBooksByCreatedBy(user.getEmail(), pageable);

            if (bookCount % limit != 0) {
                totalPages = bookCount / limit + 1;
            } else {
                totalPages = bookCount / limit;
            }
            List<Integer> pageNumbers = PaginationUtils.getPageNumbers(page, totalPages, maxVisible);

            model.addAttribute("books", books);
            model.addAttribute("totalPages", totalPages);
            model.addAttribute("currentPage", page);
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "admin/book/book-table";
    }

    @GetMapping("/categories")
    public String getCategoriesTablePage(Model model, @RequestParam("page") int page) {
        int categoryCount = this.categoryService.getAllCategories().size();
        int totalPages = 1;
        int limit = SystemConstant.LIMIT;
        int maxVisible = SystemConstant.MAX_VISIBLE_PAGES;

        Pageable pageable = PageRequest.of(page - 1, limit);
        List<Category> categories = this.categoryService.getAllCategories(pageable);

        if (categoryCount % limit != 0) {
            totalPages = categoryCount / limit + 1;
        } else {
            totalPages = categoryCount / limit;
        }
        List<Integer> pageNumbers = PaginationUtils.getPageNumbers(page, totalPages, maxVisible);

        model.addAttribute("categories", categories);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", page);
        model.addAttribute("pageNumbers", pageNumbers);
        return "admin/category/category-table";
    }

    @GetMapping("/orders")
    public String getOrdersTablePage(Model model, HttpServletRequest request, @RequestParam("page") int page) {
        HttpSession session = request.getSession();

        long userId = (long) session.getAttribute("id");
        User user = this.userService.getUserById(userId);

        String roleName = (String) session.getAttribute("roleName");

        int orderCount = 0;
        int totalPages = 1;
        int limit = 5;
        int maxVisible = SystemConstant.MAX_VISIBLE_PAGES;
        Pageable pageable = PageRequest.of(page - 1, limit);

        if (roleName.equals("ADMIN") || roleName.equals("OWNER")) {
            // update order Count
            orderCount = this.orderService.getAllOrders().size();
            // Get list order have pagination
            List<Order> orders = this.orderService.getAllOrders(pageable);
            // Update total pages
            if (orderCount % limit != 0) {
                totalPages = orderCount / limit + 1;
            } else {
                totalPages = orderCount / limit;
            }

            List<Integer> pageNumbers = PaginationUtils.getPageNumbers(page, totalPages, maxVisible);

            model.addAttribute("orders", orders);
            model.addAttribute("totalPages", totalPages);
            model.addAttribute("currentPage", page);
            model.addAttribute("pageNumbers", pageNumbers);
        } else {
            List<Book> books = this.bookService.getListBooksByCreatedBy(user.getEmail());
            List<OrderItem> orderItems = this.orderItemService.getListOrderItemsByBooks(books, pageable);

            // update order count
            for (Book book : books) {
                orderCount += this.orderItemService.getOrderItemCountByBook(book);
            }
            // update total pages
            if (orderCount % limit != 0) {
                totalPages = orderCount / limit + 1;
            } else {
                totalPages = orderCount / limit;
            }

            List<Integer> pageNumbers = PaginationUtils.getPageNumbers(page, totalPages, maxVisible);

            model.addAttribute("orderItems", orderItems);
            model.addAttribute("totalPages", totalPages);
            model.addAttribute("currentPage", page);
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "admin/order/order-table";
    }

    @GetMapping("/publishers")
    public String getPublishersTablePage(Model model, @RequestParam("page") int page) {
        int publisherCount = this.publisherService.getAllPublishers().size();
        int totalPages = 1;
        int limit = SystemConstant.LIMIT;
        int maxVisible = SystemConstant.MAX_VISIBLE_PAGES;

        Pageable pageable = PageRequest.of(page - 1, limit);
        List<Publisher> publishers = this.publisherService.getAllPublishers(pageable);

        if (publisherCount % limit != 0) {
            totalPages = (publisherCount / limit) + 1;
        } else {
            totalPages = publisherCount / limit;
        }
        List<Integer> pageNumbers = PaginationUtils.getPageNumbers(page, totalPages, maxVisible);

        model.addAttribute("publishers", publishers);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", page);
        model.addAttribute("pageNumbers", pageNumbers);
        return "admin/publisher/publisher-table";
    }

    @GetMapping("/roles")
    public String getRolesTablePage(Model model, @RequestParam("page") int page) {
        int roleCount = this.roleService.getAllRoles().size();
        int totalPages = 1;
        int limit = SystemConstant.LIMIT;
        int maxVisible = SystemConstant.MAX_VISIBLE_PAGES;

        Pageable pageable = PageRequest.of(page - 1, limit);
        List<Role> roles = this.roleService.getAllRoles(pageable);

        if (roleCount % limit != 0) {
            totalPages = roleCount / limit + 1;
        } else {
            totalPages = roleCount / limit;
        }
        List<Integer> pageNumbers = PaginationUtils.getPageNumbers(page, totalPages, maxVisible);

        model.addAttribute("roles", roles);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", page);
        model.addAttribute("pageNumbers", pageNumbers);
        return "admin/role/role-table";
    }

    @GetMapping("/users")
    public String getUsersTablePage(Model model, @RequestParam("page") int page) {
        int userCount = this.userService.getAllUsers().size();
        int totalPages = 1;
        int limit = SystemConstant.LIMIT;
        int maxVisible = SystemConstant.MAX_VISIBLE_PAGES;

        Pageable pageable = PageRequest.of(page - 1, limit);
        List<User> users = this.userService.getAllUsers(pageable);

        if (userCount % limit != 0) {
            totalPages = userCount / limit + 1;
        } else {
            totalPages = userCount / limit;
        }
        List<Integer> pageNumbers = PaginationUtils.getPageNumbers(page, totalPages, maxVisible);

        model.addAttribute("users", users);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", page);
        model.addAttribute("pageNumbers", pageNumbers);
        return "admin/user/user-table";
    }
}
