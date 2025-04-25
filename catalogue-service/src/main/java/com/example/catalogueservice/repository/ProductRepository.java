package com.example.catalogueservice.repository;

import com.example.catalogueservice.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    Iterable<Product> findAllByTitleLikeIgnoreCase(String filter);
}
