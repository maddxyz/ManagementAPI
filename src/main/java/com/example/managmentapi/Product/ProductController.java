package com.example.managmentapi.Product;

import com.example.managmentapi.Category.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class ProductController {
    private final ProductService productService;
    private final ProductRepository productRepository;

    public ProductController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @GetMapping("/product/{id}")
    public Product fetchProduct(@PathVariable Integer id) {
        return productService.getProduct(id);
    }

    @GetMapping("/products")
    public List<Product> fetchProducts() {
        return productService.getProducts();
    }


    @PostMapping("/product")
    private Integer addProduct(@RequestBody Product product) {
        return productService.add(product).getId();
    }

    @PostMapping("/product/{id}")
    private Integer editProduct(@RequestBody Product product, @PathVariable("id") Integer id) {
        return productService.edit(id, product);
    }

    @DeleteMapping("/product/{id}")
    private void deleteProduct(@PathVariable("id") Integer id) {
        if (productRepository.findById(id).isPresent())
            productService.delete(productRepository.findById(id).get());

    }

    @PostMapping("/product/{id}/category")
    private void updateCategories(@RequestBody Category category, @PathVariable("id") Integer id){
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
