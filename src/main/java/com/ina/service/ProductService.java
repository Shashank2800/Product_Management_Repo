package com.ina.service;

import com.ina.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> findById(Integer id);
    Optional<Product> findByName(String name);
    List<Product> findAll();
    Product save(Product product);
    Product update(Product product);
    void delete(Product product);
}
