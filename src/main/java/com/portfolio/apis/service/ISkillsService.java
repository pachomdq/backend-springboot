package com.portfolio.apis.service;

import com.portfolio.apis.model.Skills;
import java.util.List;

public interface ISkillsService {

    public List<Skills> getSkills();
    public void saveSkills(Skills skill);
    public void deleteSkills(int id);
    public Skills findSkill(int id);
}
