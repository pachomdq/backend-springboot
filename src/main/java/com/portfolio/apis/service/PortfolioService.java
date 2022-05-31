package com.portfolio.apis.service;

import com.portfolio.apis.model.Portfolio;
import com.portfolio.apis.repository.PortfolioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortfolioService implements IPortfolioService{
    
    @Autowired
    private PortfolioRepository portfolioRepository;
    
    @Override
    public List<Portfolio> getPortfolio() {
        List<Portfolio> listaPortfolio = portfolioRepository.findAll();
        return listaPortfolio;
    }

    @Override
    public void savePortfolio(Portfolio portfolio) {
        portfolioRepository.save(portfolio);
    }

    @Override
    public void deletePortfolio(int id) {
        portfolioRepository.deleteById(id);
    }
    
    @Override
    public Portfolio findPortfolio(int id) {
        Portfolio portfolio = portfolioRepository.findById(id).orElse(null);
        return portfolio;
    }    
}
