package com.portfolio.apis.service;

import com.portfolio.apis.model.About;
import java.util.List;

public interface IAboutService {
    public List<About> getAbout();
    public void saveAbout(About about);
    public void deleteAbout(int id);
    public About findAbout(int id);
    
}