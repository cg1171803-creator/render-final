package com.example.mongodb.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mongodb.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    
}
