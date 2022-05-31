package com.portfolio.apis.service;

import com.portfolio.apis.model.Facts;
import java.util.List;

public interface IFactsService {
    public List<Facts> getFacts();
    public void saveFacts(Facts fact);
    public void deleteFacts(int id);
    public Facts findFacts(int id);
    
}
