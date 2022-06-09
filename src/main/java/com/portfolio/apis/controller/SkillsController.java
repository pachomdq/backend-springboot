package com.portfolio.apis.controller;

import com.portfolio.apis.model.Skills;
import com.portfolio.apis.service.ISkillsService;
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
public class SkillsController {
    
    @Autowired
    private ISkillsService interSkills;
    
    @GetMapping("/skills")
    public List<Skills> getSkills(){
        return interSkills.getSkills();
    }
    
    @PostMapping("/skills/{usuario}/{token}")
    public String createSkill(@PathVariable String usuario,
                              @PathVariable String token,
                              @RequestBody Skills skill){
        if (LoginController.checkToken(usuario, token)){
            interSkills.saveSkills(skill);
            return "Ok 5/5 +++ ";
        }
        return "Usuario no autorizado. Abortando creacion de elemento skill";
    }
    
    @DeleteMapping("/skills/{id}/{usuario}/{token}")
    public String deleteSkill(@PathVariable int id,
                              @PathVariable String usuario,
                              @PathVariable String token) {
        if (LoginController.checkToken(usuario, token)){
            interSkills.deleteSkills(id);
            return "Ok 5/5 ---";
        }
        return "Usuario no autorizado. Abortando eliminacion de elemento skill";
    }
    
    @PutMapping("/skills/{id}/{usuario}/{token}")
    public Skills editSkill(@PathVariable int id,
                            @PathVariable String usuario,
                            @PathVariable String token,
                            @RequestBody Skills nSkill){
        if (LoginController.checkToken(usuario, token)){
            Skills skill = interSkills.findSkill(id);
            skill.setNombre(nSkill.getNombre());
            skill.setValor(nSkill.getValor());
            interSkills.saveSkills(skill);
            return skill;
        }
        return nSkill;
    }
}
