
package com.portfolio.apis.controller;

import com.portfolio.apis.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    
    @PostMapping("/login")
    public User login(@RequestBody User user){
        if (user.getUsuario().equals("usuario") && user.getPassword().equals("12345678")){
            user.setToken("0101");
        }
        return user;
    }
    
    @GetMapping("/login/{token}")
    public boolean checkToken(@PathVariable String token){
        return token.equals("0101");
    }    
}
