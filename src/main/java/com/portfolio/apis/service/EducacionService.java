package com.portfolio.apis.service;

import com.portfolio.apis.model.Educacion;
import com.portfolio.apis.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{
    
    @Autowired
    private EducacionRepository educacionRepository;
    
    @Override
    public List<Educacion> getEducacion() {
        List<Educacion> listaEducacion = educacionRepository.findAll();
        return listaEducacion;
    }

    @Override
    public void saveEducacion(Educacion educacion) {
        educacionRepository.save(educacion);
    }

    @Override
    public void deleteEducacion(int id) {
        educacionRepository.deleteById(id);
    }
    
    @Override
    public Educacion findEducacion(int id) {
        Educacion educacion = educacionRepository.findById(id).orElse(null);
        return educacion;
    }
    
}