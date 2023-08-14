package com.spmabg.appsuivipregols.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spmabg.appsuivipregols.entity.Indicateur;

import com.spmabg.appsuivipregols.repository.IndicateurRepository;

@Service
public class IndicateurService {
	@Autowired
    private final IndicateurRepository indicateurRepository;
    
    
    public IndicateurService(IndicateurRepository indicateurRepository) {
        this.indicateurRepository = indicateurRepository;
    }

    public Indicateur createIndicateur(Indicateur indicateur) {
        return indicateurRepository.save(indicateur);
    }

    public List<Indicateur> getAllIndicateurs() {
        return indicateurRepository.findAll();
    }

    public Optional<Indicateur> getIndicateurById(Long id) {
        return indicateurRepository.findById(id);
    }

    public Optional<Indicateur> updateIndicateur(Long id, Indicateur updatedIndicateur) {
        Optional<Indicateur> optionalIndicateur = indicateurRepository.findById(id);
        if (optionalIndicateur.isPresent()) {
        	Indicateur indicateur = optionalIndicateur.get();
        	indicateur.setLibelle(updatedIndicateur.getLibelle());
            return Optional.of(indicateurRepository.save(indicateur));
        } else {
        	return Optional.empty();
        }
    }


    public void deleteIndicateur(Long id) {
        Optional<Indicateur> optionalIndicateur = indicateurRepository.findById(id);
        if (optionalIndicateur.isPresent()) {
            indicateurRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Structure not found");
        }
    }
}
