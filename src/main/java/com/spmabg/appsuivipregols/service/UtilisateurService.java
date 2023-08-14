package com.spmabg.appsuivipregols.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spmabg.appsuivipregols.entity.Profil;
import com.spmabg.appsuivipregols.entity.Utilisateur;
import com.spmabg.appsuivipregols.repository.ProfilRepository;
import com.spmabg.appsuivipregols.repository.UtilisateurRepository;

@Service
public class UtilisateurService {
	 @Autowired
	    private UtilisateurRepository utilisateurRepository;
	 
	 @Autowired
	 	private ProfilRepository profilRepository;
	 
	 public Utilisateur trouverUtilisateurParMatricule(String matricule) {
		    return utilisateurRepository.findByMatricule(matricule);
		}
	 
	 public UtilisateurService(UtilisateurRepository utilisateurRepository) {
	        this.utilisateurRepository = utilisateurRepository;
	    }

	    public List<Utilisateur> getAllUtilisateurs() {
	        return utilisateurRepository.findAll();
	    }

	    public Optional<Utilisateur> getUtilisateurById(Long id) {
	        return utilisateurRepository.findById(id);
	    }
	    
	    public Utilisateur enregistrerUtilisateur(Utilisateur utilisateur) {
	    	Profil profil = profilRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("Profil not found"));
	    	utilisateur.setProfil(profil);
	        return utilisateurRepository.save(utilisateur);
	    }

	    public Optional<Utilisateur> updateUtilisateur(Long id, Utilisateur updatedUtilisateur) {
	        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(id);
	        if (optionalUtilisateur.isPresent()) {
	        	Utilisateur utilisateur = optionalUtilisateur.get();
	        	utilisateur.setMatricule(updatedUtilisateur.getMatricule());
	        	utilisateur.setNom(updatedUtilisateur.getNom());
	        	utilisateur.setPrenom(updatedUtilisateur.getPrenom());
	        	utilisateur.setEmail(updatedUtilisateur.getEmail());
	        	
	        	utilisateur.setPassword(updatedUtilisateur.getPassword());
	            return Optional.of (utilisateurRepository.save(utilisateur));
	        } else {
	        	throw new IllegalArgumentException("Utilisateur not found");
	        }
	    }

	    public void deleteUtilisateur(Long id) {
	        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(id);
	        if (optionalUtilisateur.isPresent()) {
	        	utilisateurRepository.deleteById(id);
	            
	        } else {
	        	throw new IllegalArgumentException("Utilisateur not found");
	        }
	    }
}
