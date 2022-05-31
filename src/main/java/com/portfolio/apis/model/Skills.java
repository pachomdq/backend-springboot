package com.portfolio.apis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Id;

@Getter @Setter
@Entity
public class Skills {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    private String nombre;
    private String valor;

    public Skills(){
    }
    
    public Skills(int id, String nombre, String valor) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
    }
    
}
