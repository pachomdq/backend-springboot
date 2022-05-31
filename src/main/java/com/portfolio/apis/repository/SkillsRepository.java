package com.portfolio.apis.repository;

import com.portfolio.apis.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepository extends JpaRepository <Skills, Integer>{
    
}
