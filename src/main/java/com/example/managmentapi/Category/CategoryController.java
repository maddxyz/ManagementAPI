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
    private Integer addCategory(@RequestBody Category category) {
        return categoryService.add(category).getId();
    }

    @PostMapping("/category/{id}")
    private Integer editCategory(@RequestBody Category category, @PathVariable("id") Integer id) {
        return categoryService.edit(id, category);
    }

    @DeleteMapping("/category/{id}")
    private void deleteCategory(@PathVariable("id") Integer id) {
        if (categoryRepository.findById(id).isPresent())
            categoryService.delete(categoryRepository.findById(id).get());

    }
}
