package com.spmabg.appsuivipregols.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spmabg.appsuivipregols.entity.Indicateur;

import com.spmabg.appsuivipregols.service.IndicateurService;



@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class IndicateurController {
	  @Autowired
    private final IndicateurService indicateurService;
  
    public IndicateurController(IndicateurService indicateurService) {
        this.indicateurService = indicateurService;
    }

    @PostMapping("/indicateur")
    public ResponseEntity<Indicateur> createIndicateur(@RequestBody Indicateur indicateur) {
        Indicateur createdIndicateur = indicateurService.createIndicateur(indicateur);
        return ResponseEntity.ok(createdIndicateur);
    }

    @GetMapping("/indicateur")
    public ResponseEntity<List<Indicateur>> getAllIndicateurs() {
        List<Indicateur> indicateurs = indicateurService.getAllIndicateurs();
        return ResponseEntity.ok(indicateurs);
    }

    @GetMapping("/indicateur/{id}")
    public ResponseEntity<Indicateur> getIndicateurById(@PathVariable("id") Long id) {
        Optional<Indicateur> optionalIndicateur = indicateurService.getIndicateurById(id);
        return optionalIndicateur.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/indicateur/{id}")
    public ResponseEntity<Optional<Indicateur>> updateIndicateur(@PathVariable("id") Long id, @RequestBody Indicateur updatedIndicateur) {
        Optional<Indicateur> indicateur = indicateurService.updateIndicateur(id, updatedIndicateur);
        return ResponseEntity.ok(indicateur);
    }

    @DeleteMapping("/indicateur/{id}")
    public ResponseEntity<Void> deleteIndicateur(@PathVariable("id") Long id) {
        indicateurService.deleteIndicateur(id);
        return ResponseEntity.noContent().build();
    }
}
