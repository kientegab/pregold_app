package com.spmabg.appsuivipregols.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spmabg.appsuivipregols.entity.Periode;

import com.spmabg.appsuivipregols.repository.PeriodeRepository;

@Service
public class PeriodeService {
	@Autowired
	private final PeriodeRepository periodeRepository;

    
    public PeriodeService(PeriodeRepository periodeRepository) {
        this.periodeRepository = periodeRepository;
    }

    public List<Periode> getAllPeriodes() {
        return periodeRepository.findAll();
    }

    public Optional<Periode> getPeriodeById(Long id) {
        return periodeRepository.findById(id);
    }

    public Periode createPeriode(Periode periode) {
        return periodeRepository.save(periode);
    }

    public Optional<Periode> updatePeriode(Long id, Periode updatedPeriode) {
        Optional<Periode> optionalPeriode = periodeRepository.findById(id);
        if (optionalPeriode.isPresent()) {
        	Periode periode = optionalPeriode.get();
        	periode.setLibelle(updatedPeriode.getLibelle());
        	periode.setDateDebut(updatedPeriode.getDateDebut());
        	periode.setDateFin(updatedPeriode.getDateFin());
        	periode.setOuvert(updatedPeriode.getOuvert());
        	periode.setVerrouiller(updatedPeriode.getVerrouiller());
        	 return Optional.of(periodeRepository.save(periode));
        } else {
        	return Optional.empty();
        }
    }

    public void deletePeriode(Long id) {
        Optional<Periode> optionalPeriode = periodeRepository.findById(id);
        if (optionalPeriode.isPresent()) {
        	periodeRepository.deleteById(id);
            
        } else {
        	throw new IllegalArgumentException("Periode not found");
        }
    }
}
