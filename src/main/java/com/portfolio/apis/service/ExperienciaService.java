package com.portfolio.apis.service;

import com.portfolio.apis.model.Experiencia;
import com.portfolio.apis.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService{
    
    @Autowired
    private ExperienciaRepository experienciaRepository;
    
    @Override
    public List<Experiencia> getExperiencia() {
        List<Experiencia> listaExperiencia = experienciaRepository.findAll();
        return listaExperiencia;
    }

    @Override
    public void saveExperiencia(Experiencia experiencia) {
        experienciaRepository.save(experiencia);
    }

    @Override
    public void deleteExperiencia(int id) {
        experienciaRepository.deleteById(id);
    }
    
    @Override
    public Experiencia findExperiencia(int id) {
        Experiencia experiencia = experienciaRepository.findById(id).orElse(null);
        return experiencia;
    }
    
}

