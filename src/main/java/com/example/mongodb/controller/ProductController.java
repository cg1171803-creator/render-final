package com.example.mongodb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongodb.service.ProductService;
import com.example.mongodb.model.Product;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
	private ProductService service;
	
	@GetMapping()
	public Iterable<Product> getAll() {
		return service.getAll();
	}
	
	@GetMapping("{name}")
	public Iterable<Product> searchByName(@PathVariable String name) {
		return service.searchByName(name);
	}
	
	@PostMapping()
	public ResponseEntity<?> add(@RequestBody Product product) {
		service.add(product);
		return new ResponseEntity<String>("Saved record", HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> update(@RequestBody Product product, @PathVariable String id) {
		service.update(product, id);
		return new ResponseEntity<String>("Updated record", HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		service.delete(id);
		return new ResponseEntity<String>("Deleted record", HttpStatus.OK);
	}
}

