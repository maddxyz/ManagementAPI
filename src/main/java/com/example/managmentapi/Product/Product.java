package com.example.managmentapi.Product;

import com.example.managmentapi.Business.Business;
import com.example.managmentapi.Category.Category;
import com.example.managmentapi.Menu.Menu;
import com.example.managmentapi.Order.Orders;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
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
    @ManyToOne
    @JsonBackReference(value="prod-cat")
    private Category category;
    @ManyToOne
    @JoinColumn(name="BusinessId")
    @JsonBackReference(value="prod-bus")
    private Business business;
    @OneToMany(mappedBy = "product",targetEntity = Orders.class)
    private List<Orders> orders = new ArrayList<>();
    @ManyToOne
    private Menu menu;
}
