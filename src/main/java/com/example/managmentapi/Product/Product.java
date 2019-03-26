package com.example.managmentapi.Product;

import com.example.managmentapi.Business.Business;
import com.example.managmentapi.Category.Category;
import com.example.managmentapi.Menu.Menu;
import com.example.managmentapi.Order.Order;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double price;
    private int stock;
    private int image;
    @ManyToMany
    private Set<Category> category;
    @ManyToOne
    @JoinColumn(name="BusinessId")
    @JsonBackReference
    private Business business;
    @OneToMany(mappedBy = "product",targetEntity = Order.class, fetch=FetchType.EAGER)
    private Set<Order> orders;
    @ManyToOne
    private Menu menu;
}
