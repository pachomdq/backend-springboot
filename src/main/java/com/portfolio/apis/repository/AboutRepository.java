package com.portfolio.apis.repository;

import com.portfolio.apis.model.About;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRepository extends JpaRepository <About, Integer>{
    
}