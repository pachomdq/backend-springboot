package com.portfolio.apis.repository;

import com.portfolio.apis.model.Facts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactsRepository extends JpaRepository <Facts, Integer>{
    
}
