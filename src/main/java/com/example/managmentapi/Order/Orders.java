package com.example.managmentapi.Order;

import com.example.managmentapi.Product.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private int timestamp;
    private double amount;

    @Column(columnDefinition = "integer default 0")
    private int status;
    private int quantity;

    @Column(columnDefinition = "integer default 0")
    private int paid;

    @ManyToOne
    @JsonBackReference
    private Product product;
}
