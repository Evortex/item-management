package com.example.managerapp.repository;


import com.example.managerapp.entity.Product;

import java.util.*;

public class InMemoryProductRepository implements ProductRepository {

    private final List<Product> products = Collections.synchronizedList(new LinkedList<Product>());
}
