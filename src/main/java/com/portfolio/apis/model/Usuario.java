package com.portfolio.apis.model;

public class Usuario {
    private String usr;
    private String psw;
    private String token;
    
    public Usuario(){
    }

    public Usuario(String usr, String psw, String token) {
        this.usr = usr;
        this.psw = psw;
        this.token = token;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    public boolean passwordCorrect(String usuario, String password){
        return this.psw.equals(password) && this.usr.equals(usuario);
    }
}
