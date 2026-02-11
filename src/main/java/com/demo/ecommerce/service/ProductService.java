package com.demo.ecommerce.service;

import com.demo.ecommerce.model.Product;
import com.demo.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public Product addProduct(Product product) {

        return repo.save(product);
    }


    public List<Product> getProductsByOwner(String email) {
        return repo.findByOwnerEmail(email);
    }

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public void deleteProduct(String id) {
        repo.deleteById(id);
    }
}