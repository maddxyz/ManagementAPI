package com.example.managmentapi.Category;

import com.example.managmentapi.Menu.Menu;
import com.example.managmentapi.Order.Orders;
import com.example.managmentapi.Product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany
    private List<Product> products = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="order_id")
    private Orders orders;
    @OneToMany
    private List<Menu> menus = new ArrayList<>();
}
