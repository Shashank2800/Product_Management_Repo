package com.ina.repository;

import com.ina.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Integer> {
    public Optional<Product> findByProductId(Integer id);
    public  Optional<Product>  findByProductName(String name);
}
