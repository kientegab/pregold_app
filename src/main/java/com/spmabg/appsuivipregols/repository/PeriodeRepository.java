package com.spmabg.appsuivipregols.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.spmabg.appsuivipregols.entity.Periode;

public interface PeriodeRepository extends JpaRepository<Periode, Long>{
	Optional<Periode> findById(Long idPeriode);
}
