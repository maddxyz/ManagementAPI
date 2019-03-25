package com.example.managmentapi.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product getProduct(Integer id) {
        return productRepository.findById(id).orElse(new Product());
    }

    public List<Product> getProducts(){
        return (List<Product>) productRepository.findAll();
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


    public void delete(Product product) {
        productRepository.delete(product);
    }
}
