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


import com.spmabg.appsuivipregols.entity.Periode;

import com.spmabg.appsuivipregols.service.PeriodeService;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PeriodeController {
	
	@Autowired
	private final PeriodeService periodeService;

    
    public PeriodeController(PeriodeService periodeService) {
        this.periodeService = periodeService;
    }

    @PostMapping("/periode")
    public ResponseEntity<Periode> createPeriode(@RequestBody Periode periode) {
    	Periode createdPeriode = periodeService.createPeriode(periode);
        return ResponseEntity.ok(createdPeriode);
    }

    @GetMapping("/periode")
    public ResponseEntity<List<Periode>> getAllPeriodes() {
        List<Periode> periode = periodeService.getAllPeriodes();
        return ResponseEntity.ok(periode);
    }

    @GetMapping("/periode/{id}")
    public ResponseEntity<Periode> getPeriodeById(@PathVariable("id") Long id) {
        Optional<Periode> optionalPeriode= periodeService.getPeriodeById(id);
        return optionalPeriode.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/periode/{id}")
    public ResponseEntity<Optional<Periode>> updatePeriode(@PathVariable("id") Long id, @RequestBody Periode updatedPeriode) {
        Optional<Periode> periode = periodeService.updatePeriode(id, updatedPeriode);
        return ResponseEntity.ok(periode);
    }

    @DeleteMapping("/periode/{id}")
    public ResponseEntity<Void> deletePeriode(@PathVariable("id") Long id) {
    	periodeService.deletePeriode(id);
        return ResponseEntity.noContent().build();
    }
}
