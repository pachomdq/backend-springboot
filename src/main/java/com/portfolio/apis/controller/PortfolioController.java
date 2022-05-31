package com.portfolio.apis.controller;

import com.portfolio.apis.model.Portfolio;
import com.portfolio.apis.service.IPortfolioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortfolioController {
    
    @Autowired
    private IPortfolioService interPortfolio;
    
    @GetMapping("/portfolio")
    public List<Portfolio> getPortfolio(){
        return interPortfolio.getPortfolio();
    }
    
    @PostMapping("/portfolio")
    public String createPortfolio(@RequestBody Portfolio portfolio){
        interPortfolio.savePortfolio(portfolio);
        return "OK 5/5 +++";
    }
    
    @DeleteMapping("/portfolio/{id}")
    public String deletePortfolio(@PathVariable int id){
        interPortfolio.deletePortfolio(id);
        return "OK 5/5 ---";
    }
    
    @PutMapping("/portfolio/{id}")
    public Portfolio editPortfolio(@PathVariable int id,
                          @RequestParam("src") String nSrc,
                          @RequestParam("thumb") String nThumb,
                          @RequestParam("caption") String nCaption){
        Portfolio portfolio = interPortfolio.findPortfolio(id);
        portfolio.setSrc(nSrc);
        portfolio.setThumb(nThumb);
        portfolio.setCaption(nCaption);
        interPortfolio.savePortfolio(portfolio);
        return portfolio;
    }
}
