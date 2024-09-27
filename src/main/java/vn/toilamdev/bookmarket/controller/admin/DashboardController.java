package vn.toilamdev.bookmarket.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.toilamdev.bookmarket.domain.Role;
import vn.toilamdev.bookmarket.domain.User;
import vn.toilamdev.bookmarket.service.RoleService;
import vn.toilamdev.bookmarket.service.UserService;

@Controller
@RequestMapping("/admin")
public class DashboardController {

    private final RoleService roleService;
    private final UserService userService;

    public DashboardController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping
    public String getDashboardPage(Model model) {
        return "admin/dashboard/dashboard-home";
    }

    @GetMapping("/authors")
    public String getAuthorsTablePage(Model model) {
        return "admin/author/author-table";
    }

    @GetMapping("/books")
    public String getBooksTablePage(Model model) {
        return "admin/book/book-table";
    }

    @GetMapping("/categories")
    public String getCategoriesTablePage(Model model) {
        return "admin/category/category-table";
    }

    @GetMapping("/orders")
    public String getOrdersTablePage(Model model) {
        return "admin/order/order-table";
    }

    @GetMapping("/publishers")
    public String getPublishersTablePage(Model model) {
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
