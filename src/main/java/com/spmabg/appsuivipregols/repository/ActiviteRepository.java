package com.spmabg.appsuivipregols.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spmabg.appsuivipregols.entity.Activite;



public interface ActiviteRepository extends JpaRepository<Activite, Long> {

	@Query("SELECT a FROM Activite a WHERE a.indicateur.id = :indicateurId")
    List<Activite> findByIndicateurId(Long indicateurId);

}

