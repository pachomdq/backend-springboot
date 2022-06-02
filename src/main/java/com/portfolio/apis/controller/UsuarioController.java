package com.portfolio.apis.controller;

import com.portfolio.apis.model.Usuario;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", methods = {RequestMethod.POST})
@RestController
public class UsuarioController {
    private Usuario usuario;
    UsuarioController(){
        this.usuario = new Usuario("usuario","12345678","");
    }
    
    @PostMapping("/login")
    public boolean login(String usr, String psw){
        return this.usuario.passwordCorrect(usr,psw);
    }
}
