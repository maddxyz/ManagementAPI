package com.example.managmentapi.Category;

import com.example.managmentapi.Menu.MenuRepository;
import com.example.managmentapi.Product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    MenuRepository menuRepository;
    @Autowired
    ProductRepository productRepository;

    public Category add(Category category){
        return categoryRepository.save(category);
    }

    public List<Category> getCategories(){
        return (List<Category>) categoryRepository.findAll();
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

    public void delete(Integer id) {
        if (categoryRepository.findById(id).isPresent())
            categoryRepository.delete(categoryRepository.findById(id).get());
    }

    public void addProd(Integer id, Integer idProd) {
        if (categoryRepository.findById(id).isPresent() && productRepository.findById(idProd).isPresent()) {
            productRepository.findById(idProd).get().setCategory(categoryRepository.findById(id).get());
            productRepository.save(productRepository.findById(idProd).get());
        }
    }

    public void removeProd(Integer id, Integer idProd) {
        if (categoryRepository.findById(id).isPresent() && productRepository.findById(idProd).isPresent()) {
            productRepository.findById(idProd).get().setCategory(null);
            productRepository.save(productRepository.findById(idProd).get());
        }
    }

    public void addMenu(Integer id, Integer idTable) {
        if (categoryRepository.findById(id).isPresent() && menuRepository.findById(idTable).isPresent()) {
            menuRepository.findById(idTable).get().setCategory(categoryRepository.findById(id).get());
            menuRepository.save(menuRepository.findById(idTable).get());
        }
    }

    public void removeMenu(Integer id, Integer idTable) {
        if (categoryRepository.findById(id).isPresent() && menuRepository.findById(idTable).isPresent()) {
            menuRepository.findById(idTable).get().setCategory(null);
            menuRepository.save(menuRepository.findById(idTable).get());
        }
    }
}
