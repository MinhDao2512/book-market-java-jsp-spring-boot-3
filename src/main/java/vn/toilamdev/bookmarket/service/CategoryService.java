package vn.toilamdev.bookmarket.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.toilamdev.bookmarket.domain.Category;
import vn.toilamdev.bookmarket.repository.CategoryRepository;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return this.categoryRepository.findAll();
    }

    public Category getCategoryByName(String name) {
        return this.categoryRepository.findByName(name);
    }

}
