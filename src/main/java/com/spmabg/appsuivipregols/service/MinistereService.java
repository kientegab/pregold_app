package com.spmabg.appsuivipregols.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spmabg.appsuivipregols.entity.Ministere;

import com.spmabg.appsuivipregols.repository.MinistereRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MinistereService {
	@Autowired
    private final MinistereRepository ministereRepository;

    
    public MinistereService(MinistereRepository ministereRepository) {
        this.ministereRepository = ministereRepository;
    }

    public List<Ministere> getAllMinisteres() {
        return ministereRepository.findAll();
    }

    public Optional<Ministere> getMinistereById(Long id) {
        return ministereRepository.findById(id);
    }

    public Ministere createMinistere(Ministere ministere) {
        return ministereRepository.save(ministere);
    }

    public Optional<Ministere> updateMinistere(Long id, Ministere updatedMinistere) {
        Optional<Ministere> optionalMinistere = ministereRepository.findById(id);
        if (optionalMinistere.isPresent()) {
        	Ministere ministere = optionalMinistere.get();
        	ministere.setLibelle(updatedMinistere.getLibelle());
        	ministere.setSigle(updatedMinistere.getSigle());
            return Optional.of(ministereRepository.save(ministere));
        } else {
        	return Optional.empty();
        }
    }

    public void deleteMinistere(Long id) {
        Optional<Ministere> optionalMinistere = ministereRepository.findById(id);
        if (optionalMinistere.isPresent()) {
            ministereRepository.deleteById(id);
            
        } else {
        	throw new IllegalArgumentException("Ministere not found");
        }
    }
}
