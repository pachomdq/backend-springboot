package com.portfolio.apis.controller;

import com.portfolio.apis.model.Portfolio;
import com.portfolio.apis.service.IPortfolioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@RestController
public class PortfolioController {
    
    @Autowired
    private IPortfolioService interPortfolio;
    
    @GetMapping("/portfolio")
    public List<Portfolio> getPortfolio(){
        return interPortfolio.getPortfolio();
    }
    
    @PostMapping("/portfolio/{usuario}/{token}")
    public String createPortfolio(@PathVariable String usuario,
                                  @PathVariable String token,
                                  @RequestBody Portfolio portfolio){
        if (LoginController.checkToken(usuario, token)){
            interPortfolio.savePortfolio(portfolio);
            return "OK 5/5 +++";
        }
        return "Usuario no autorizado. Abortando creacion de elemento portfolio";
    }
    
    @DeleteMapping("/portfolio/{id}/{usuario}/{token}")
    public String deletePortfolio(@PathVariable int id,
                                  @PathVariable String usuario,
                                  @PathVariable String token){
        if (LoginController.checkToken(usuario, token)){
            interPortfolio.deletePortfolio(id);
            return "OK 5/5 ---";
        }
        return "Usuario no autorizado. Abortando eliminacion de elemento portfolio";
    }
    
    @PutMapping("/portfolio/{id}/{usuario}/{token}")
    public Portfolio editPortfolio(@PathVariable int id,
                                   @PathVariable String usuario,
                                   @PathVariable String token,
                                   @RequestBody Portfolio nPortfolio){
        if (LoginController.checkToken(usuario, token)){
            Portfolio portfolio = interPortfolio.findPortfolio(id);
            portfolio.setSrc(nPortfolio.getSrc());
            portfolio.setThumb(nPortfolio.getThumb());
            portfolio.setCaption(nPortfolio.getCaption());
            interPortfolio.savePortfolio(portfolio);
            return portfolio;
        }
        return nPortfolio;
    }
}
