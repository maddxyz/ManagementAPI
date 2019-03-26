package com.example.managmentapi.Place;

import com.example.managmentapi.Business.Business;
import com.example.managmentapi.Product.Product;
import com.example.managmentapi.Table.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Place {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private Integer number;

    @ManyToOne
    @JsonBackReference
    private Table table;
}
