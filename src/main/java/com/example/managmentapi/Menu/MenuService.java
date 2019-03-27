package com.example.managmentapi.Menu;

import com.example.managmentapi.Category.Category;
import com.example.managmentapi.Category.CategoryRepository;
import com.example.managmentapi.Product.Product;
import com.example.managmentapi.Product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    public Menu getMenu(Integer id) {
        return menuRepository.findById(id).orElse(new Menu());
    }

    public List<Menu> getMenus(){
        return (List<Menu>) menuRepository.findAll();
    }

    public Integer edit(Integer id, Menu menu) {
        if (menuRepository.findById(id).isPresent()) {
            menuRepository.delete(menuRepository.findById(id).get());
            menu.setId(id);
            return menuRepository.save(menu).getId();
        }
        else return -1;
    }

    public Menu add(Menu menu) {
        return menuRepository.save(menu);
    }


    public void delete(Menu menu) {
        menuRepository.delete(menu);
    }

    public void makeAvailable(Menu menu) {
        menu.setAvailable(1);
        menuRepository.save(menu);
    }

    public void makeUnavailable(Menu menu) {
        menu.setAvailable(0);
        menuRepository.save(menu);
    }

    public void addProduct(Integer id, Integer idProd) {
        if (menuRepository.findById(id).isPresent() && productRepository.findById(idProd).isPresent()) {
            productRepository.findById(idProd).get().setMenu(menuRepository.findById(id).get());
            productRepository.save(productRepository.findById(idProd).get());
        }
    }

    public void removeProduct(Integer id, Integer idProd) {
        if (menuRepository.findById(id).isPresent() && productRepository.findById(idProd).isPresent()) {
            productRepository.findById(idProd).get().setMenu(null);
            productRepository.save(productRepository.findById(idProd).get());
        }
    }
}
