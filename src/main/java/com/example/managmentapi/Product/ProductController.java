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
    public Set<Product> fetchProducts() {
        return productService.getProducts();
    }


    @PostMapping("/product")
    public Integer addProduct(@RequestBody Product product) {
        return productService.add(product).getId();
    }

    @PostMapping("/product/{id}")
    public Integer editProduct(@RequestBody Product product, @PathVariable("id") Integer id) {
        return productService.edit(id, product);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable("id") Integer id) {
        productService.delete(id);
    }

    @PostMapping("/product/{id}/category")
    public void updateCategory(@RequestBody Category category, @PathVariable("id") Integer id){
        productService.updateCategory(id, category);
    }
}
