package vn.toilamdev.bookmarket.controller.admin.rest;

import java.util.Map;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
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
    public ResponseEntity<?> createCategory(@Valid @ModelAttribute Category category, BindingResult bindingResult) {

        if (bindingResult.hasFieldErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        Category newCategory = this.categoryService.handleCreateCategory(category);
        if (newCategory != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(newCategory);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(newCategory);
        }
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<?> updateCategory(@Valid @ModelAttribute Category category,
            BindingResult bindingResult, @PathVariable long id) {
        if (bindingResult.hasFieldErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

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
