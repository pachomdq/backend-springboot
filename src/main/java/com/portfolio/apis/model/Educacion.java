package com.portfolio.apis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    private String nombre;
    private String fecha;
    private String lugar;
    private String detalle;

    public Educacion() {
    }

    public Educacion(int id, String nombre, String fecha, String lugar, String detalle) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.detalle = detalle;
    }
    
}
