package com.example.managmentapi.Business;
import com.example.managmentapi.Product.Product;
import com.example.managmentapi.manager.Manager;
import com.example.managmentapi.Table.Table;

import javax.persistence.*;
import java.util.*;
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
    @OneToMany(mappedBy = "business",targetEntity = Manager.class, fetch=FetchType.EAGER)
    private Set<Manager> managers;
    @OneToMany(mappedBy = "business",targetEntity = Product.class, fetch=FetchType.EAGER)
    private Set<Product> products;
    @OneToMany(mappedBy = "business",targetEntity = Table.class, fetch=FetchType.EAGER)
    private Set<Table> tables;

}
