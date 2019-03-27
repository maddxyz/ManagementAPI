package com.example.managmentapi.Menu;

import com.example.managmentapi.Category.Category;
import com.example.managmentapi.Category.CategoryRepository;
import com.example.managmentapi.Product.Product;
import com.example.managmentapi.Product.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {
    private final MenuService menuService;
    private final MenuRepository menuRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public MenuController(MenuService menuService, MenuRepository menuRepository,
                          ProductRepository productRepository,
                          CategoryRepository categoryRepository) {
        this.menuService = menuService;
        this.menuRepository = menuRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/menu/{id}")
    public Menu fetchMenu(@PathVariable Integer id) {
        return menuService.getMenu(id);
    }

    @GetMapping("/menus")
    public List<Menu> fetchMenus() {
        return menuService.getMenus();
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

    @PostMapping("/menu/{id}/product/{idProd}/add")
    public void addProduct(@PathVariable("idProd") Integer idProd, @PathVariable("id") Integer id){
        menuService.addProduct(id, idProd);
    }

    @PostMapping("/menu/{id}/product/{idProd}/remove")
    public void removeMenu(@PathVariable("idProd") Integer idProd, @PathVariable("id") Integer id){
        menuService.removeProduct(id, idProd);
    }
}
