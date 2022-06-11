package com.portfolio.apis.controller;

import com.portfolio.apis.model.About;
import com.portfolio.apis.service.IAboutService;
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
public class AboutController {
    
    @Autowired
    private IAboutService interAbout;
    
    @GetMapping("/about")
    public List<About> getAbout(){
        return interAbout.getAbout();
    }
    //Este elemento no se debe crear. Es unico en la base de datos en este diseño
    @PostMapping("/about")
    public String createAbout(@RequestBody About about){
        //interAbout.saveAbout(about);
        return "Metodo no permitido";
    }
     
    
    //Este elemento no se puede borrar en este diseño
    @DeleteMapping("/about/{id}")
    public String deleteAbout(@PathVariable int id){
            //interAbout.deleteAbout(id);
            return "Metodo no permitido";
    }
    
    @PutMapping("/about/{id}/{usuario}/{token}")
    public About editAbout(@PathVariable int id,
                           @PathVariable String usuario,
                           @PathVariable String token,
                           @RequestBody About nAbout){
        if (LoginController.checkToken(usuario, token)){          
            About about = interAbout.findAbout(id);
            about.setNombre(nAbout.getNombre());
            about.setImagenURL(nAbout.getImagenURL());
            about.setIntroduccion(nAbout.getIntroduccion());
            about.setCargo(nAbout.getCargo());
            about.setDetalleCargo(nAbout.getDetalleCargo());
            about.setFechaNacimiento(nAbout.getFechaNacimiento());
            about.setDireccion(nAbout.getDireccion());
            about.setTelefono(nAbout.getTelefono());
            about.setCiudad(nAbout.getCiudad());
            about.setEdad(nAbout.getEdad());
            about.setEmail(nAbout.getEmail());
            about.setFreelance(nAbout.getFreelance());
            about.setNotas(nAbout.getNotas());
            about.setResumen(nAbout.getResumen());
            interAbout.saveAbout(about);
            return about;
        }
        return nAbout;
    }
}
