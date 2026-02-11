package com.demo.ecommerce.repository;

import com.demo.ecommerce.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    List<User> findAllByEmail(String email);
}