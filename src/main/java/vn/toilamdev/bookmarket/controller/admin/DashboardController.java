package vn.toilamdev.bookmarket.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.toilamdev.bookmarket.domain.Role;
import vn.toilamdev.bookmarket.service.RoleService;

@Controller
@RequestMapping("/admin")
public class DashboardController {

    private final RoleService roleService;

    public DashboardController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public String getDashboardPage(Model model) {
        return "admin/dashboard/dashboard-home";
    }

    @GetMapping("/author")
    public String getAuthorsTablePage(Model model) {
        return "admin/author/author-table";
    }

    @GetMapping("/book")
    public String getBooksTablePage(Model model) {
        return "admin/book/book-table";
    }

    @GetMapping("/category")
    public String getCategoriesTablePage(Model model) {
        return "admin/category/category-table";
    }

    @GetMapping("/order")
    public String getOrdersTablePage(Model model) {
        return "admin/order/order-table";
    }

    @GetMapping("/publisher")
    public String getPublishersTablePage(Model model) {
        return "admin/publisher/publisher-table";
    }

    @GetMapping("/role")
    public String getRolesTablePage(Model model) {
        List<Role> roles = this.roleService.getAllRoles();
        model.addAttribute("roles", roles);
        return "admin/role/role-table";
    }

    @GetMapping("/user")
    public String getUsersTablePage(Model model) {
        return "admin/user/user-table";
    }
}
