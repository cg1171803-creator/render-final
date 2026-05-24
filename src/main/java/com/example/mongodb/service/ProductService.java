package com.example.mongodb.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.mongodb.model.Product;
import com.example.mongodb.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
	private ProductRepository repo;
    @Autowired
	private MongoTemplate mongoTemplate;

    public List<Product> getAll() {
		return repo.findAll();
	}

    public Iterable<Product> searchByName(@PathVariable String name) {
        Query query = new Query();
		query.addCriteria(Criteria.where("name").regex("^"+name));
        List<Product> products = mongoTemplate.find(query, Product.class);
		return products;
    }

    public void add(Product product){
        repo.save(product);
    }

    public void update(Product product, String id){
        repo.findById(id).get();
		product.setId(id);
		repo.save(product);
    }

    public void delete(String id){
        repo.findById(id).get();
		repo.deleteById(id);
    }
}
