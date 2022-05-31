package com.portfolio.apis.repository;

import com.portfolio.apis.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends JpaRepository <Portfolio, Integer>{
}