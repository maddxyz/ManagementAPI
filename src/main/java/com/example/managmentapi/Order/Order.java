package com.example.managmentapi.Order;

import com.example.managmentapi.Product.Product;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private Date timestamp;
    private double amount;

    @Column(columnDefinition = "int default 0")
    private int status;
    private int quantity;

    @Column(columnDefinition = "int default 0")
    private int paid;

    @ManyToOne
    private Product product;
}
