package com.thoughtworks.training.zhangtian.todoservice.controller;

import com.thoughtworks.training.zhangtian.todoservice.model.User;
import com.thoughtworks.training.zhangtian.todoservice.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${private.password}")
    private String privatePassword;

    @PostMapping("/users")
    public Integer create(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping("/users/{id}")
    public User getOne(@PathVariable Integer id) {
        User one = userService.getOne(id);
        return one;
    }

    @GetMapping("/users")
    public List<User> getAll() {
        List<User> users = userService.getAll();
        return users;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user) {
        if (userService.validate(user)) {
            HashMap<String, Object> claims = new HashMap<>();
            claims.put("name", user.getName());
            claims.put("password", user.getPassword());

            String token = Jwts.builder()
                    .addClaims(claims)
                    .signWith(SignatureAlgorithm.HS512, privatePassword.getBytes())
                    .compact();
            return ResponseEntity.ok(token);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
