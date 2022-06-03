package com.portfolio.apis.controller;

import com.portfolio.apis.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

@RestController
public class UserController {
    
    @PostMapping("user")
    public User login(@RequestParam("user") String username,
                      @RequestParam("password") String pwd ){
        if (username == "usuario" && pwd == "12345678"){
            Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
            String token = Jwts.builder().setSubject(username).signWith(key).compact();
            User user = new User();
            user.setUser(username);
            user.setToken(token);
            return user;
        }
        return null;
    }
}
