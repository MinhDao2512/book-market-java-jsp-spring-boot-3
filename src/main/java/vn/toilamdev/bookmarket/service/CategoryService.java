package vn.toilamdev.bookmarket.service;

import java.util.List;
import java.util.Date;

import org.springframework.stereotype.Service;

import vn.toilamdev.bookmarket.domain.BookCategorization;
import vn.toilamdev.bookmarket.domain.Category;
import vn.toilamdev.bookmarket.repository.BookCategorizationRepository;
import vn.toilamdev.bookmarket.repository.CategoryRepository;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final BookCategorizationRepository bookCategorizationRepository;

    public CategoryService(CategoryRepository categoryRepository,
            BookCategorizationRepository bookCategorizationRepository) {
        this.categoryRepository = categoryRepository;
        this.bookCategorizationRepository = bookCategorizationRepository;
    }

    public List<Category> getAllCategories() {
        return this.categoryRepository.findAll();
    }

    public Category getCategoryByName(String name) {
        return this.categoryRepository.findByName(name);
    }

    public Category getCategoryById(long id) {
        return this.categoryRepository.findById(id);
    }

    public Category handleCreateCategory(Category category) {
        boolean existsCategory = this.categoryRepository.existsByName(category.getName());
        if (!existsCategory) {
            category.setCreatedAt(new Date(System.currentTimeMillis()));
            return this.categoryRepository.save(category);
        } else {
            return null;
        }
    }

    public Category handleUpdateCategory(Category category, long id) {
        Category currentCategory = this.categoryRepository.findById(id);
        if (currentCategory != null) {
            currentCategory.setDescription(category.getDescription());
            currentCategory.setUpdatedAt(new Date(System.currentTimeMillis()));

            currentCategory = this.categoryRepository.save(currentCategory);
        }
        return currentCategory;
    }

    public boolean handleDeleteCategory(long id) {
        Category currentCategory = this.categoryRepository.findById(id);
        if (currentCategory != null) {
            for (BookCategorization bc : currentCategory.getBookCategorizations()) {
                bookCategorizationRepository.deleteById(bc.getId());
            }

            this.categoryRepository.deleteById(currentCategory.getId());
            return true;
        } else {
            return false;
        }
    }
}
