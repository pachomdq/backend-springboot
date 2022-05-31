package com.portfolio.apis.service;

import com.portfolio.apis.model.About;
import com.portfolio.apis.repository.AboutRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AboutService implements IAboutService{
    
    @Autowired
    private AboutRepository aboutRepository;
    
    @Override
    public List<About> getAbout() {
        List<About> listaAbout = aboutRepository.findAll();
        return listaAbout;
    }

    @Override
    public void saveAbout(About about) {
        aboutRepository.save(about);
    }

    @Override
    public void deleteAbout(int id) {
        aboutRepository.deleteById(id);
    }
    
    @Override
    public About findAbout(int id) {
        About about = aboutRepository.findById(id).orElse(null);
        return about;
    }
    
}