package com.portfolio.apis.controller;

import com.portfolio.apis.model.Experiencia;
import com.portfolio.apis.service.IExperienciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RestController
public class ExperienciaController {
    
    @Autowired
    private IExperienciaService interExperiencia;
    
    @GetMapping("/experiencia")
    public List<Experiencia> getExperiencia(){
        return interExperiencia.getExperiencia();
    }
    
    @PostMapping("/experiencia")
    public String createFact(@RequestBody Experiencia experiencia){
        interExperiencia.saveExperiencia(experiencia);
        return "OK 5/5 +++";
    }
    
    @DeleteMapping("/experiencia/{id}")
    public String deleteFact(@PathVariable int id){
        interExperiencia.deleteExperiencia(id);
        return "OK 5/5 ---";
    }
    
    @PutMapping("/experiencia/{id}")
    public Experiencia editFact(@PathVariable int id,
                          @RequestParam("nombre") String nNombre,
                          @RequestParam("fecha") String nFecha,
                          @RequestParam("lugar") String nLugar,
                          @RequestParam("detalle") String nDetalle){
        Experiencia experiencia = interExperiencia.findExperiencia(id);
        experiencia.setNombre(nNombre);
        experiencia.setFecha(nFecha);
        experiencia.setLugar(nLugar);
        experiencia.setDetalle(nDetalle);
        interExperiencia.saveExperiencia(experiencia);
        return experiencia;
    }
}
