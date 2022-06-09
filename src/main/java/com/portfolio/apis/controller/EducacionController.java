package com.portfolio.apis.controller;

import com.portfolio.apis.model.Educacion;
import com.portfolio.apis.service.IEducacionService;
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
public class EducacionController {
    
    @Autowired
    private IEducacionService interEducacion;
    
    @GetMapping("/educacion")
    public List<Educacion> getEducacion(){
        return interEducacion.getEducacion();
    }
    
    @PostMapping("/educacion/{usuario}/{token}")
    public String createEducacion(@PathVariable String usuario,
                             @PathVariable String token,
                             @RequestBody Educacion educacion){
        
        if (LoginController.checkToken(usuario, token)){
            interEducacion.saveEducacion(educacion);
            return "OK 5/5 +++";
        }
        return "Usuario sin autorizacion. Abortando creacion de elemento educacion";
    }
    
    @DeleteMapping("/educacion/{id}/{usuario}/{token}")
    public String deleteEducacion(@PathVariable int id,
                             @PathVariable String usuario,
                             @PathVariable String token){
        if (LoginController.checkToken(usuario, token)){
            interEducacion.deleteEducacion(id);
            return "OK 5/5 ---";
        }
        return "Usuario sin autorizacion. Abortando eliminacion de elemento educacion";
    }
    
    @PutMapping("/educacion/{id}/{usuario}/{token}")
    public Educacion editEducacion(@PathVariable int id,
                              @PathVariable String usuario,
                              @PathVariable String token,
                              @RequestBody Educacion nEducacion){
        if (LoginController.checkToken(usuario, token)){
            Educacion educacion = interEducacion.findEducacion(id);
            educacion.setNombre(nEducacion.getNombre());
            educacion.setFecha(nEducacion.getFecha());
            educacion.setLugar(nEducacion.getLugar());
            educacion.setDetalle(nEducacion.getDetalle());
            interEducacion.saveEducacion(educacion);
            return educacion;
        }
        return nEducacion;
    }
}
