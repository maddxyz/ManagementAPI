package com.example.managmentapi.Table;

import com.example.managmentapi.Business.Business;
import com.example.managmentapi.Place.Place;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Table {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private Integer number;
    @ManyToOne
    @JoinColumn(name="BusinessId")
    @JsonBackReference
    private Business business;

    @OneToMany(mappedBy = "table",targetEntity = Place.class)
    private List<Place> places = new ArrayList<>();
}
