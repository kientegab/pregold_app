package com.spmabg.appsuivipregols.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spmabg.appsuivipregols.entity.Activite;
import com.spmabg.appsuivipregols.entity.Evaluation;
import com.spmabg.appsuivipregols.entity.Indicateur;
import com.spmabg.appsuivipregols.repository.ActiviteRepository;
import com.spmabg.appsuivipregols.repository.EvaluationRepository;
import com.spmabg.appsuivipregols.repository.IndicateurRepository;


@Service
public class EvaluationService {
    @Autowired
    private EvaluationRepository evaluationRepository;

    @Autowired
    private IndicateurRepository indicateurRepository;

    public List<Indicateur> getAllIndicateurs() {
        return indicateurRepository.findAll();
    }

    @Autowired
    private ActiviteRepository activiteRepository;

    public List<Activite> getActivitesPourIndicateur(Long idIndicateur) {
        return activiteRepository.findByIndicateurId(idIndicateur);
    }
    
    
   
}





