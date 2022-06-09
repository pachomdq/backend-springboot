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
//import org.springframework.web.bind.annotation.RequestParam;
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
    
    @PostMapping("/experiencia/{usuario}/{token}")
    public String createExperiencia(@PathVariable String usuario,
                             @PathVariable String token,
                             @RequestBody Experiencia experiencia){
        if (LoginController.checkToken(usuario, token)){
            interExperiencia.saveExperiencia(experiencia);
            return "OK 5/5 +++";
        }
        return "Usuario sin autorizacion. Abortando creacion de elemento experiencia";
    }
    
    @DeleteMapping("/experiencia/{id}/{usuario}/{token}")
    public String deleteExperiencia(@PathVariable int id,
                             @PathVariable String usuario,
                             @PathVariable String token){
        if (LoginController.checkToken(usuario, token)){
            interExperiencia.deleteExperiencia(id);
            return "OK 5/5 ---";
        }
        return "Usuario sin autorizacion. Abortando eliminacion de elemento experiencia";
    }
    
    @PutMapping("/experiencia/{id}/{usuario}/{token}")
    public Experiencia editExperiencia(@PathVariable int id,
                                       @PathVariable String usuario,
                                       @PathVariable String token,
                                       @RequestBody Experiencia nExperiencia){
        if (LoginController.checkToken(usuario, token)){
            Experiencia experiencia = interExperiencia.findExperiencia(id);
            experiencia.setNombre(nExperiencia.getNombre());
            experiencia.setFecha(nExperiencia.getFecha());
            experiencia.setLugar(nExperiencia.getLugar());
            experiencia.setDetalle(nExperiencia.getDetalle());
            interExperiencia.saveExperiencia(experiencia);
            return experiencia;
        }
        return nExperiencia;
    }
}
