package com.example.managmentapi.Product;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    private Integer addProduct(@RequestBody Product manager) {
        return productService.add(manager).getId();
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
}
