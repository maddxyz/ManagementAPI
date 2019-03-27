package com.example.managmentapi.Business;
import com.example.managmentapi.Product.Product;
import com.example.managmentapi.manager.Manager;
import com.example.managmentapi.Table.Table;

import javax.persistence.*;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BusinessId")
    private Integer id;
    private int disponibility;
    @OneToMany(mappedBy = "business",targetEntity = Manager.class)
    private List<Manager> managers = new ArrayList<>();
    @OneToMany(mappedBy = "business",targetEntity = Product.class)
    private List<Product> products = new ArrayList<>();
    @OneToMany(mappedBy = "business",targetEntity = Table.class)
    private List<Table> tables = new ArrayList<>();

}
