package com.portfolio.apis.controller;

import com.portfolio.apis.model.Skills;
import com.portfolio.apis.service.ISkillsService;
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
public class SkillsController {
    
    @Autowired
    private ISkillsService interSkills;
    
    @GetMapping("/skills")
    public List<Skills> getSkills(){
        return interSkills.getSkills();
    }
    
    @PostMapping("/skills")
    public String createSkill(@RequestBody Skills skill){
        interSkills.saveSkills(skill);
        return "Ok 5/5 +++ ";
    }
    
    @DeleteMapping("/skills/{id}")
    public String deleteSkill(@PathVariable int id) {
        interSkills.deleteSkills(id);
        return "Ok 5/5 ---";
    }
    
    @PutMapping("/skills/{id}")
    public Skills editSkill(@PathVariable int id,
                            @RequestParam("nombre") String nuevoNombre,
                            @RequestParam("valor") String nuevoValor
                            ){
        Skills skill = interSkills.findSkill(id);
        skill.setNombre(nuevoNombre);
        skill.setValor(nuevoValor);
        interSkills.saveSkills(skill);
        
        return skill;
    }
    
    
    
    
}
