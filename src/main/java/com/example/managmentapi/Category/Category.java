package com.example.managmentapi.Category;

import com.example.managmentapi.Order.Order;
import com.example.managmentapi.Product.Product;
import com.example.managmentapi.manager.Manager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    @ManyToMany
    private Set<Product> products;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="order_id")
    private Order order;
    @ManyToMany
    private Set<Menu> menus;
}
