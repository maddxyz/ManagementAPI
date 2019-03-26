package com.example.managmentapi.Table;

import com.example.managmentapi.Business.Business;
import com.example.managmentapi.Order.Order;
import com.example.managmentapi.Place.Place;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Table {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private Integer number;
    @ManyToOne
    @JoinColumn(name="BusinessId")
    @JsonBackReference
    private Business business;

    @OneToMany(mappedBy = "table",targetEntity = Place.class, fetch=FetchType.EAGER)
    private Set<Place> places;
}
