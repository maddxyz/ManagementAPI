package com.example.managmentapi.Category;

import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public List<Category> fetchCategories() {
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

    @PostMapping("/category/{id}/menu/{idMenu}/attach")
    public void addMenu(@PathVariable("idMenu") Integer idMenu, @PathVariable("id") Integer id){
        categoryService.addMenu(id, idMenu);
    }

    @PostMapping("/category/{id}/menu/{idCat}/remove")
    public void removeMenu(@PathVariable("idMenu") Integer idMenu, @PathVariable("id") Integer id){
        categoryService.removeMenu(id, idMenu);
    }

    @PostMapping("/category/{id}/product/{idProd}/attach")
    public void addProd(@PathVariable("idProd") Integer idProd, @PathVariable("id") Integer id){
        categoryService.addProd(id, idProd);
    }

    @PostMapping("/category/{id}/menu/{idProd}/remove")
    public void removeProd(@PathVariable("idProd") Integer idProd, @PathVariable("id") Integer id){
        categoryService.removeProd(id, idProd);
    }
}
