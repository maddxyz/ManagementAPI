package com.example.managmentapi.Menu;

import com.example.managmentapi.Category.Category;
import com.example.managmentapi.Product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        menu.setStatus(0);
        menuRepository.save(menu);
    }

    public void addProduct(Menu menu, Product product) {
        menu.addProduct(product);
        menuRepository.save(menu);
    }

    public void removeProduct(Menu menu, Product product) {
        menu.removeProduct(product);
        menuRepository.save(menu);
    }

    public void addCat(Menu menu, Category cat) {
        menu.addCategory(cat);
        menuRepository.save(menu);
    }

    public void removeCat(Menu menu, Category cat) {
        menu.addCategory(cat);
        menuRepository.save(menu);
    }
}
