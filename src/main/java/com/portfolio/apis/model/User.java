package com.portfolio.apis.model;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
    public String usuario;
    public String password;
    public String token;
    
    public User(){}

    public User(String usuario, String password, String token) {
        this.usuario = usuario;
        this.password = password;
        this.token = token;
    }
}