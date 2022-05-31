package com.portfolio.apis.controller;

import com.portfolio.apis.model.About;
import com.portfolio.apis.service.IAboutService;
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
public class AboutController {
    
    @Autowired
    private IAboutService interAbout;
    
    @GetMapping("/about")
    public List<About> getAbout(){
        return interAbout.getAbout();
    }
    /* Este elemento no se debe crear. Es unico en la base de datos en este diseño
    @PostMapping("/about")
    public String createFact(@RequestBody About about){
        interAbout.saveAbout(about);
        return "OK 5/5 +++";
    }
    */ 
    
    /* Este elemento no se puede borrar en este diseño
    @DeleteMapping("/about/{id}")
    public String deleteFact(@PathVariable int id){
        interAbout.deleteAbout(id);
        return "OK 5/5 ---";
    }*/
    
    @PutMapping("/about/{id}")
    public About editFact(@PathVariable int id,
                          @RequestParam("nombre") String nNombre,
                          @RequestParam("imagenURL") String nImagenURL,
                          @RequestParam("introduccion") String nIntroduccion,
                          @RequestParam("cargo") String nCargo,
                          @RequestParam("detalleCargo") String nDetalleCargo,
                          @RequestParam("fechaNacimiento") String nFechaNacimiento,
                          @RequestParam("telefono") String nTelefono,
                          @RequestParam("direccion") String nDireccion,
                          @RequestParam("ciudad") String nCiudad,
                          @RequestParam("edad") String nEdad,
                          @RequestParam("email") String nEmail,
                          @RequestParam("freelance") String nFreelance,
                          @RequestParam("notas") String nNotas,
                          @RequestParam("resumen") String nResumen){
        About about = interAbout.findAbout(id);
        about.setNombre(nNombre);
        about.setImagenURL(nImagenURL);
        about.setIntroduccion(nIntroduccion);
        about.setCargo(nCargo);
        about.setDetalleCargo(nDetalleCargo);
        about.setFechaNacimiento(nFechaNacimiento);
        about.setDireccion(nDireccion);
        about.setTelefono(nTelefono);
        about.setCiudad(nCiudad);
        about.setEdad(nEdad);
        about.setEmail(nEmail);
        about.setFreelance(nFreelance);
        about.setNotas(nNotas);
        about.setResumen(nResumen);
        interAbout.saveAbout(about);
        return about;
    }
}
