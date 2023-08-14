package com.spmabg.appsuivipregols.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spmabg.appsuivipregols.entity.Utilisateur;



public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	Utilisateur findByMatricule(String matricule);

}
