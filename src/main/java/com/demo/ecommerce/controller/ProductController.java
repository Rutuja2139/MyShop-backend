package com.demo.ecommerce.controller;

import com.demo.ecommerce.model.Product;
import com.demo.ecommerce.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")

@CrossOrigin(origins = "${app.frontend.url}", allowCredentials = "true")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) { this.service = service; }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {

        return service.addProduct(product);
    }

    @GetMapping
    public List<Product> getAll() {
        return service.getAllProducts();
    }
}