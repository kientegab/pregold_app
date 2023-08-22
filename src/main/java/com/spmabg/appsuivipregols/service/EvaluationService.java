package com.spmabg.appsuivipregols.service;

import java.util.List;
import java.util.Map;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.spmabg.appsuivipregols.entity.Activite;
import com.spmabg.appsuivipregols.repository.ActiviteRepository;
import com.spmabg.appsuivipregols.repository.EvaluationRepository;
import com.spmabg.appsuivipregols.repository.IndicateurRepository;
import com.spmabg.appsuivipregols.entity.Evaluation;
import com.spmabg.appsuivipregols.entity.Indicateur;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Optional;



@Service
public class EvaluationService {
    @Autowired
    private IndicateurRepository indicateurRepository;
    
    @Autowired
    private EvaluationRepository evaluationRepository;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Indicateur> getAllIndicateurs() {
        return indicateurRepository.findAll();
    }

    @Autowired
    private ActiviteRepository activiteRepository;

    public List<Activite> getActivitesPourIndicateur(Long idIndicateur) {
        return activiteRepository.findByIndicateurId(idIndicateur);
    }
    
    public Map<String, Double> calculateTaux(List<Map<String, Object>> activitesEvaluees) {
        Map<String, Double> tauxMap = new HashMap<>();
        double tauxTotal = 0.0;

        Indicateur indicateur = null; // Initialize the indicator outside the loop
            
        for (Map<String, Object> activiteData : activitesEvaluees) {
            Map<String, Object> activiteMap = (Map<String, Object>) activiteData.get("activite");
                
            int activiteId = activiteMap.containsKey("idActivite") ? (int) activiteMap.get("idActivite") : -1;
                
            Object valeurObject = activiteData.get("valeur");
            Object poidsObject = activiteData.get("poids");
            
            if (valeurObject instanceof Number && poidsObject instanceof Number) {
                int valeur = ((Number) valeurObject).intValue();
                double poids = ((Number) poidsObject).doubleValue();

                Optional<Activite> activiteOptional = activiteRepository.findByIdActivite(activiteId);
                if (activiteOptional.isPresent()) {
                    Activite activite = activiteOptional.get();
                    double cible = activite.getCible().doubleValue();
                    double tauxActivite = (valeur / cible) * poids;
                    tauxMap.put(activite.getLibelle(), tauxActivite);
                    tauxTotal += tauxActivite;

                    Evaluation evaluation = evaluationRepository.findByActivite(activite);
                    if (evaluation == null) {
                        evaluation = new Evaluation();
                        evaluation.setActivite(activite);
                    }

                    evaluation.setValeur((int) valeur);
                    evaluation.setPoids(poids);
                    evaluation.setTaux(tauxActivite);

                    evaluationRepository.save(evaluation);

                    if (indicateur == null) {
                        indicateur = activite.getIndicateur();
                    }
                } else {
                    System.out.println("No activite found for id: " + activiteId);
                }
            } else {
                System.out.println("Invalid valeur or poids for activite: " + activiteId);
            }
        }

        if (indicateur != null) {
            indicateur.setValeur(tauxTotal);
            indicateurRepository.save(indicateur);
        }

        System.out.println("Total taux calculated: " + tauxTotal);
        return tauxMap;
    }


}





