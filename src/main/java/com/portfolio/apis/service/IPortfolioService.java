package com.portfolio.apis.service;

import com.portfolio.apis.model.Portfolio;
import java.util.List;

public interface IPortfolioService {

    public List<Portfolio> getPortfolio();
    public void savePortfolio(Portfolio portfolio);
    public void deletePortfolio(int id);
    public Portfolio findPortfolio(int id);
}
