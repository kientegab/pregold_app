package com.spmabg.appsuivipregols.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spmabg.appsuivipregols.entity.Profil;


@Repository
public interface ProfilRepository extends JpaRepository<Profil, Long>{

}
