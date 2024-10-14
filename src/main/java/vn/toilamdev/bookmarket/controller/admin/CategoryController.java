package vn.toilamdev.bookmarket.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.toilamdev.bookmarket.domain.Category;
import vn.toilamdev.bookmarket.service.CategoryService;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/create")
    public String getCreateCategoryPage() {
        return "admin/category/category-create";
    }

    @GetMapping("/detail/{id}")
    public String getDetailCategoryPage(Model model, @PathVariable long id) {
        Category currentCategory = this.categoryService.getCategoryById(id);
        model.addAttribute("currentCategory", currentCategory);
        return "admin/category/category-detail";
    }

    @GetMapping("/update/{id}")
    public String getUpdateCategoryPage(Model model, @PathVariable long id) {
        Category currentCategory = this.categoryService.getCategoryById(id);
        model.addAttribute("currentCategory", currentCategory);
        return "admin/category/category-update";
    }
}
