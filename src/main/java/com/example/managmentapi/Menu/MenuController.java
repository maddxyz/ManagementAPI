package com.example.managmentapi.Menu;

import com.example.managmentapi.Business.BusinessRepository;
import com.example.managmentapi.Business.BusinessService;
import com.example.managmentapi.Category.CategoryRepository;
import com.example.managmentapi.Category.CategoryService;
import com.example.managmentapi.Product.Product;
import com.example.managmentapi.Product.ProductRepository;
import com.example.managmentapi.Product.ProductService;
import com.example.managmentapi.manager.ManagerRepository;
import com.example.managmentapi.manager.ManagerService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class MenuController {
    private final MenuService menuService;
    private final MenuRepository menuRepository;
    private final ManagerService managerService;
    private final ManagerRepository managerRepository;
    private final BusinessRepository businessRepository;
    private final BusinessService businessService;
    private final ProductRepository productRepository;
    private final ProductService productService;
    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;

    public MenuController(MenuService menuService, MenuRepository menuRepository, ManagerService managerService,
                          ManagerRepository managerRepository, BusinessRepository businessRepository, BusinessService businessService,
                          ProductRepository productRepository, ProductService productService,
                          CategoryRepository categoryRepository, CategoryService categoryService) {
        this.menuService = menuService;
        this.menuRepository = menuRepository;
        this.managerService = managerService;
        this.managerRepository = managerRepository;
        this.businessRepository = businessRepository;
        this.businessService = businessService;
        this.productRepository = productRepository;
        this.productService = productService;
        this.categoryRepository = categoryRepository;
        this.categoryService = categoryService;
    }

    @GetMapping("/menu/{id}")
    public Menu fetchMenu(@PathVariable Integer id) {
        return menuService.getMenu(id);
    }


    @PostMapping("/menu")
    private Integer addMenu(@RequestBody Menu menu) {
        return menuService.add(menu).getId();
    }

    @PostMapping("/menu/{id}")
    private Integer editMenu(@RequestBody Menu menu, @PathVariable("id") Integer id) {
        return menuService.edit(id, menu);
    }

    @DeleteMapping("/menu/{id}")
    private void deleteMenu(@PathVariable("id") Integer id) {
        if (menuRepository.findById(id).isPresent())
            menuService.delete(menuRepository.findById(id).get());

    }

    @GetMapping("/menu/{id}/make_available")
    private void makeAvailable(@PathVariable("id") Integer id) {
        if (menuRepository.findById(id).isPresent())
            menuService.makeAvailable(menuRepository.findById(id).get());
    }

    @GetMapping("/menu/{id}/make_unavailable")
    private void makeUnavailable(@PathVariable("id") Integer id) {
        if (menuRepository.findById(id).isPresent())
            menuService.makeUnavailable(menuRepository.findById(id).get());
    }

    @GetMapping("/menu/{id}/add/{idProduct}")
    private void addProduct(@PathVariable("id") Integer id, @PathVariable("idProduct") Integer idProduct) {
        if (menuRepository.findById(id).isPresent())
            menuService.addProduct(menuRepository.findById(id).get(), productRepository.findById(idProduct).get());
    }

    @GetMapping("/menu/{id}/remove/{idProduct}")
    private void removeProduct(@PathVariable("id") Integer id, @PathVariable("idProduct") Integer idProduct) {
        if (menuRepository.findById(id).isPresent())
            menuService.removeProduct(menuRepository.findById(id).get(), productRepository.findById(idProduct).get());
    }

    @GetMapping("/menu/{id}/add/{idCat}")
    private void addCat(@PathVariable("id") Integer id, @PathVariable("idCat") Integer idCat) {
        if (menuRepository.findById(id).isPresent())
            menuService.addCat(menuRepository.findById(id).get(), categoryRepository.findById(idCat).get());
    }

    @GetMapping("/menu/{id}/remove/{idCat}")
    private void removeCat(@PathVariable("id") Integer id, @PathVariable("idCat") Integer idCat) {
        if (menuRepository.findById(id).isPresent())
            menuService.removeCat(menuRepository.findById(id).get(), categoryRepository.findById(idCat).get());
    }
}
