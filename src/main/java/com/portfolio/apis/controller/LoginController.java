
package com.portfolio.apis.controller;

import com.portfolio.apis.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {
    String key = "claveprivada";
    @PostMapping("/login")
    public User login(@RequestBody User user){
        
        if (user.getUsuario().equals("usuario") && user.getPassword().equals("12345678")){
            
            String token = org.apache.commons.codec.digest.DigestUtils.sha256Hex(user.getUsuario() + this.key);
            user.setToken(token);
        }
        return user;
    }
    
    @GetMapping("/login/{usr}/{token}")
    public boolean checkToken(@PathVariable String usr, @PathVariable String token){
        String tokenGenerado = org.apache.commons.codec.digest.DigestUtils.sha256Hex(usr + this.key);
        return token.equals(tokenGenerado);
    }    
}
