package com.example.managmentapi.Menu;

import com.example.managmentapi.Category.Category;
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
public class Menu {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int stock;
    private double price;
    private int image;

    @Column(columnDefinition = "int default 0")
    private int available;

    @OneToMany(mappedBy = "menu",targetEntity = Product.class)
    private List<Product> products = new ArrayList<>();

    @ManyToOne
    private Category category;
}
