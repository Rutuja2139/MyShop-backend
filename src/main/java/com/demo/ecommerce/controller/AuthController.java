package com.demo.ecommerce.controller;

import com.demo.ecommerce.model.User;
import com.demo.ecommerce.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "${app.frontend.url}", allowCredentials = "true")
public class AuthController {
    private final UserService service;

    public AuthController(UserService service) { this.service = service; }

    @GetMapping("/user/info")
    public Map<String, Object> getUserInfo(@AuthenticationPrincipal OAuth2User principal) {
        Map<String, Object> details = new HashMap<>();
        if (principal != null) {
            details.put("name", principal.getAttribute("name"));
            details.put("email", principal.getAttribute("email"));

            
            details.put("picture", principal.getAttribute("picture"));
        }
        return details;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> loginData) {
        Map<String, Object> response = new HashMap<>();
     
        String email = loginData.get("email");
        String password = loginData.get("password");

        User loggedInUser = service.login(email, password);
        if (loggedInUser != null) {
            response.put("status", "success");
            response.put("name", loggedInUser.getName());
            response.put("email", loggedInUser.getEmail());
          
            response.put("id", loggedInUser.getId()); 
        } else {
            response.put("status", "fail");
        }
        return response;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
  
        User registeredUser = service.register(user);
        if (registeredUser == null) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "User already exists with this email.");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
        }
        return ResponseEntity.ok(registeredUser);
    }
}
