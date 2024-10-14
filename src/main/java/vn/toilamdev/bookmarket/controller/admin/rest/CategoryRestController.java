package vn.toilamdev.bookmarket.controller.admin.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.toilamdev.bookmarket.domain.Category;
import vn.toilamdev.bookmarket.service.CategoryService;

@RestController
@RequestMapping("/api/admin")
public class CategoryRestController {
    private final CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/categories")
    public ResponseEntity<Category> createCategory(@ModelAttribute Category category) {
        Category newCategory = this.categoryService.handleCreateCategory(category);
        if (newCategory != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(newCategory);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(newCategory);
        }
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<Category> updateCategory(@ModelAttribute Category category, @PathVariable long id) {
        Category currentCategory = this.categoryService.handleUpdateCategory(category, id);
        if (currentCategory != null) {
            return ResponseEntity.status(HttpStatus.OK).body(currentCategory);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(category);
        }
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable long id) {
        boolean checkDelete = this.categoryService.handleDeleteCategory(id);
        if (checkDelete) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
