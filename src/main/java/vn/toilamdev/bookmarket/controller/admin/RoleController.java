package vn.toilamdev.bookmarket.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.toilamdev.bookmarket.domain.Role;
import vn.toilamdev.bookmarket.service.RoleService;

@Controller
@RequestMapping("/admin/role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/detail/{id}")
    public String getCreateRolePage(Model model, @PathVariable long id) {
        Role role = this.roleService.getRoleById(id);
        model.addAttribute("role", role);
        return "admin/role/role-detail";
    }
}
