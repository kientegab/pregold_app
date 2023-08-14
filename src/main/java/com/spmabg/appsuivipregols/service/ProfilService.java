package com.spmabg.appsuivipregols.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spmabg.appsuivipregols.entity.Profil;

import com.spmabg.appsuivipregols.repository.ProfilRepository;
@Service
public class ProfilService {
	 @Autowired
	private final ProfilRepository profilRepository;
    public ProfilService(ProfilRepository profilRepository) {
        this.profilRepository = profilRepository;
    }

    public Profil createProfil(Profil profil) {
        return profilRepository.save(profil);
    }

    public List<Profil> getAllProfils() {
        return profilRepository.findAll();
    }

    public Optional<Profil> getProfilById(Long id) {
        return profilRepository.findById(id);
    }

   
    
    public Optional<Profil> updateProfil(Long id, Profil updatedProfil) {
        Optional<Profil> optionalProfil = profilRepository.findById(id);
        if (optionalProfil.isPresent()) {
        	Profil profil = optionalProfil.get();
        	profil.setLibelle(updatedProfil.getLibelle());
        	profil.setCode(updatedProfil.getCode());
            return Optional.of(profilRepository.save(profil));
        } else {
        	return Optional.empty();
        }
    }

    public void deleteProfil(Long id) {
        profilRepository.deleteById(id);
    }
}
