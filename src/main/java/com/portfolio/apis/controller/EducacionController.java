package com.portfolio.apis.controller;

import com.portfolio.apis.model.Educacion;
import com.portfolio.apis.service.IEducacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EducacionController {
    
    @Autowired
    private IEducacionService interEducacion;
    
    @GetMapping("/educacion")
    public List<Educacion> getEducacion(){
        return interEducacion.getEducacion();
    }
    
    @PostMapping("/educacion")
    public String createFact(@RequestBody Educacion educacion){
        interEducacion.saveEducacion(educacion);
        return "OK 5/5 +++";
    }
    
    @DeleteMapping("/educacion/{id}")
    public String deleteFact(@PathVariable int id){
        interEducacion.deleteEducacion(id);
        return "OK 5/5 ---";
    }
    
    @PutMapping("/educacion/{id}")
    public Educacion editFact(@PathVariable int id,
                          @RequestParam("nombre") String nNombre,
                          @RequestParam("fecha") String nFecha,
                          @RequestParam("lugar") String nLugar,
                          @RequestParam("detalle") String nDetalle){
        Educacion educacion = interEducacion.findEducacion(id);
        educacion.setNombre(nNombre);
        educacion.setFecha(nFecha);
        educacion.setLugar(nLugar);
        educacion.setDetalle(nDetalle);
        interEducacion.saveEducacion(educacion);
        return educacion;
    }
}
