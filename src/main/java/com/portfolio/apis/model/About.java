package com.portfolio.apis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class About {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    private String nombre;
    private String imagenURL;
    private String introduccion;
    private String cargo;
    private String detalleCargo;
    private String fechaNacimiento;
    private String telefono;
    private String direccion;
    private String ciudad;
    private String edad;
    private String email;
    private String freelance;
    private String notas;
    private String resumen;

    public About() {
    }

    public About(int id, String nombre, String imagenURL, String introduccion, String cargo, String detalleCargo, String fechaNacimiento, String telefono, String direccion, String ciudad, String edad, String email, String freelance, String notas, String resumen) {
        this.id = id;
        this.nombre = nombre;
        this.imagenURL = imagenURL;
        this.introduccion = introduccion;
        this.cargo = cargo;
        this.detalleCargo = detalleCargo;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.edad = edad;
        this.email = email;
        this.freelance = freelance;
        this.notas = notas;
        this.resumen = resumen;
    }
    
    
}
