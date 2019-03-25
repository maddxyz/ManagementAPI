package com.example.managmentapi.Business;
import com.example.managmentapi.manager.Manager;

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
    private int id;
    @OneToMany(targetEntity = Manager.class, mappedBy = "business", cascade = CascadeType.ALL)
    private List<Manager> managers;
}
