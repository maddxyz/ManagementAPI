package com.example.managmentapi.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Category add(Category category){
        return categoryRepository.save(category);
    }

    public Set<Category> getCategories(){
        return (Set<Category>) categoryRepository.findAll();
    }

    public Category getCategory(Integer id){
        return categoryRepository.findById(id).orElse(new Category());
    }

    public Integer edit(Integer id, Category category) {
        if (categoryRepository.findById(id).isPresent()) {
            category.setId(id);
            return categoryRepository.save(category).getId();
        }
        else return -1;
    }

    public void delete(Category category) {
        categoryRepository.delete(category);
    }
}