package com.portfolio.apis.service;

import com.portfolio.apis.model.Facts;
import com.portfolio.apis.repository.FactsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactsService implements IFactsService{
    
    @Autowired
    private FactsRepository factsRepository;
    
    @Override
    public List<Facts> getFacts() {
        List<Facts> listaFacts = factsRepository.findAll();
        return listaFacts;
    }

    @Override
    public void saveFacts(Facts fact) {
        factsRepository.save(fact);
    }

    @Override
    public void deleteFacts(int id) {
        factsRepository.deleteById(id);
    }
    
    @Override
    public Facts findFacts(int id) {
        Facts fact = factsRepository.findById(id).orElse(null);
        return fact;
    }
    
}
