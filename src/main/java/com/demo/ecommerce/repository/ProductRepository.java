package com.demo.ecommerce.repository;

import com.demo.ecommerce.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findByOwnerEmail(String email);
}