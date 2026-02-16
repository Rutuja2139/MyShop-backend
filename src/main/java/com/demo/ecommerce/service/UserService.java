package com.demo.ecommerce.service;

import com.demo.ecommerce.model.User;
import com.demo.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) { 
        this.repo = repo; 
    }

    public User register(User user) {
        List<User> existingUsers = repo.findAllByEmail(user.getEmail());
        if (!existingUsers.isEmpty()) {
            return null;
        }
        return repo.save(user);
    }

    public User login(String email, String password) {
        List<User> users = repo.findAllByEmail(email);
        for (User user : users) {
            if (user.getPassword() != null && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
