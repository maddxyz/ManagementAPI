package com.example.managmentapi.Product;

import com.example.managmentapi.Business.Business;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findByBusiness(Business business);
}
