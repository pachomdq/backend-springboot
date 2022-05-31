package com.portfolio.apis.service;

import com.portfolio.apis.model.Skills;
import com.portfolio.apis.repository.SkillsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillsService implements ISkillsService{
    
    @Autowired
    private SkillsRepository skillsRepository;
    
    @Override
    public List<Skills> getSkills() {
        List<Skills> listaSkills = skillsRepository.findAll();
        return listaSkills;
    }

    @Override
    public void saveSkills(Skills skill) {
        skillsRepository.save(skill);
    }

    @Override
    public void deleteSkills(int id) {
        skillsRepository.deleteById(id);
    }
    
    @Override
    public Skills findSkill(int id) {
        Skills skill = skillsRepository.findById(id).orElse(null);
        return skill;
    }
    
}
