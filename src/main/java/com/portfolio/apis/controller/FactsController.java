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
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @PostMapping("/facts")
    public String createFact(@RequestBody Facts fact){
        interFacts.saveFacts(fact);
        return "OK 5/5 +++";
    }
    
    @DeleteMapping("/facts/{id}")
    public String deleteFact(@PathVariable int id){
        interFacts.deleteFacts(id);
        return "OK 5/5 ---";
    }
    
    @PutMapping("/facts/{id}")
    public Facts editFact(@PathVariable int id,
                          @RequestParam("imagenURL") String nImagenURL,
                          @RequestParam("texto") String nTexto,
                          @RequestParam("horas") int nHoras){
        Facts fact = interFacts.findFacts(id);
        fact.setHoras(nHoras);
        fact.setTexto(nTexto);
        fact.setImagenURL(nImagenURL);
        interFacts.saveFacts(fact);
        return fact;
    }
}
