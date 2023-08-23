package com.spmabg.appsuivipregols.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spmabg.appsuivipregols.entity.Activite;

import com.spmabg.appsuivipregols.entity.Indicateur;
import com.spmabg.appsuivipregols.service.EvaluationService;

@CrossOrigin("http://localhost:8000")
@RestController
@RequestMapping("/api")
public class EvaluationController {
    @Autowired
    private EvaluationService evaluationService;

    @GetMapping("/evaluation/indicateurs")
    public ResponseEntity<List<Indicateur>> getAllIndicateurs() {
        List<Indicateur> indicateurs = evaluationService.getAllIndicateurs();
        return ResponseEntity.ok(indicateurs);
    }

    @GetMapping("/evaluation/activites/{idIndicateur}")
    public ResponseEntity<List<Activite>> getActivitesPourIndicateur(@PathVariable Long idIndicateur) {
        List<Activite> activites = evaluationService.getActivitesPourIndicateur(idIndicateur);
        return ResponseEntity.ok(activites);
    }
}



