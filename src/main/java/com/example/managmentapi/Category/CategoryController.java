package com.example.managmentapi.Category;

import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryService categoryService, CategoryRepository categoryRepository) {
        this.categoryService = categoryService;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/category/{id}")
    public Category fetchCategory(@PathVariable Integer id) {
        return categoryService.getCategory(id);
    }

    @GetMapping("/categories")
    public Set<Category> fetchCategories() {
        return categoryService.getCategories();
    }


    @PostMapping("/category")
    public Integer addCategory(@RequestBody Category category) {
        return categoryService.add(category).getId();
    }

    @PostMapping("/category/{id}")
    public Integer editCategory(@RequestBody Category category, @PathVariable("id") Integer id) {
        return categoryService.edit(id, category);
    }

    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable("id") Integer id) {
        categoryService.delete(id);
    }
}
