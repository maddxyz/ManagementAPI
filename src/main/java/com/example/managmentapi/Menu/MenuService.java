package com.example.managmentapi.Menu;

import com.example.managmentapi.Category.Category;
import com.example.managmentapi.Product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

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

    public void updateCategory(Integer id, Category category){
        if (menuRepository.findById(id).isPresent()){
            Set<Category> menuCategories = menuRepository.findById(id).get().getCategory();
            if (menuCategories.contains(category)){
                menuCategories.remove(category);
            }
            else {
                menuCategories.add(category);
            }
        }
    }

    public void updateProduct(Integer id, Product product){
        if (menuRepository.findById(id).isPresent()){
            Set<Product> menuProducts = menuRepository.findById(id).get().getProducts();
            if (menuProducts.contains(product)){
                menuProducts.remove(product);
            }
            else {
                menuProducts.add(product);
            }
        }
    }
}
