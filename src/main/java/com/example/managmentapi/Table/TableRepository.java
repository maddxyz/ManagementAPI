package com.example.managmentapi.Table;

import com.example.managmentapi.Business.Business;
import com.example.managmentapi.Product.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TableRepository extends CrudRepository<Table, Integer> {
}
