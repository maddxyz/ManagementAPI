package com.example.managmentapi.Product;

import com.example.managmentapi.Category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product getProduct(Integer id) {
        return productRepository.findById(id).orElse(new Product());
    }

    public Set<Product> getProducts(){
        return (Set<Product>) productRepository.findAll();
    }

    public Integer edit(Integer id, Product product) {
        if (productRepository.findById(id).isPresent()) {
            productRepository.delete(productRepository.findById(id).get());
            product.setId(id);
            return productRepository.save(product).getId();
        }
        else return -1;
    }

    public Product add(Product product) {
        return productRepository.save(product);
    }


    public void delete(Integer id) {
        if (productRepository.findById(id).isPresent())
            productRepository.delete(productRepository.findById(id).get());
    }

    public void updateCategory(Integer id, Category category){
        if (productRepository.findById(id).isPresent()){
            Set<Category> productCategories = productRepository.findById(id).get().getCategory();
            if (productCategories.contains(category)){
                productCategories.remove(category);
            }
            else {
                productCategories.add(category);
            }
        }
    }
}
