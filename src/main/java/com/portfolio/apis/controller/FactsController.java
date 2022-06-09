package com.portfolio.apis.controller;

import com.portfolio.apis.model.Facts;
import com.portfolio.apis.service.IFactsService;
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
public class FactsController {
    
    @Autowired
    private IFactsService interFacts;
    
    @GetMapping("/facts")
    public List<Facts> getFacts(){
        return interFacts.getFacts();
    }
    
    @PostMapping("/facts/{usuario}/{token}")
    public String createFact(@PathVariable String usuario,
                             @PathVariable String token,
                             @RequestBody Facts fact){
        if (LoginController.checkToken(usuario, token)){
            interFacts.saveFacts(fact);
            return "OK 5/5 +++";
        }
        return "Usuario no autorizado. Abortando creacion de elemento facts";
    }
    
    @DeleteMapping("/facts/{id}/{usuario}/{token}") 
    public String deleteFact(@PathVariable int id,
                             @PathVariable String usuario,
                             @PathVariable String token){
        if (LoginController.checkToken(usuario, token)){
            interFacts.deleteFacts(id);
            return "OK 5/5 ---";
        }
        return "Usuario no autorizado. Abortando eliminacion de elemento facts";
    }
    
    @PutMapping("/facts/{id}/{usuario}/{token}")
    public Facts editFact(@PathVariable int id,
                          @PathVariable String usuario,
                          @PathVariable String token,
                          @RequestBody Facts nFact){
        if (LoginController.checkToken(usuario, token)){
            Facts fact = interFacts.findFacts(id);
            fact.setHoras(nFact.getHoras());
            fact.setTexto(nFact.getTexto());
            fact.setImagenURL(nFact.getImagenURL());
            interFacts.saveFacts(fact);
            return fact;
        }
        return nFact;
    }
}
