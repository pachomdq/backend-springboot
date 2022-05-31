package com.portfolio.apis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Facts {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    private String texto;
    private String imagenURL;
    private int horas;

    public Facts() {
    }

    public Facts(int id, String texto, String imagenURL, int horas) {
        this.id = id;
        this.texto = texto;
        this.imagenURL = imagenURL;
        this.horas = horas;
    }
    
    
    
}
