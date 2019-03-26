package com.example.managmentapi.Order;

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

    @Column(nullable = false, columnDefinition = "int default 0")
    private int status;
    private int quantity;

    @Column(nullable = false, columnDefinition = "int default 0")
    private int paid;
}
