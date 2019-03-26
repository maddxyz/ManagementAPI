package com.example.managmentapi.manager;

import com.example.managmentapi.Business.Business;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    @ManyToOne
    @JoinColumn(name="BusinessId")
    @JsonBackReference
    private Business business;
}
