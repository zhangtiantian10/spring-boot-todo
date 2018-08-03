package com.thoughtworks.training.zhangtian.todoservice;

import com.thoughtworks.training.zhangtian.todoservice.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class TokenGenerate {
    @Value("${private.password}")
    private String privatePassword;

    public String getToken(User user) {
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("name", user.getName());
        claims.put("id", user.getId());

        return Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS512, privatePassword.getBytes())
                .compact();
    }
}