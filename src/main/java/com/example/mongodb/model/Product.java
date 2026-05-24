package com.example.mongodb.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "product")
public class Product {
    
    @Id
	@Field(targetType = FieldType.OBJECT_ID)
    private String id;
    private String name;
    private double price;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
 
 
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", pricer=" + price + "]";
    }
}

