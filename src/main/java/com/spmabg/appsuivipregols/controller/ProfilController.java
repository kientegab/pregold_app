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


import com.spmabg.appsuivipregols.entity.Profil;

import com.spmabg.appsuivipregols.service.ProfilService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProfilController {
	
	@Autowired
	private final ProfilService profilService;

    
    public ProfilController(ProfilService profilService) {
        this.profilService = profilService;
    }

    @PostMapping("/profil")
    public ResponseEntity<Profil> createProfil(@RequestBody Profil profil) {
        Profil createdProfil = profilService.createProfil(profil);
        return ResponseEntity.ok(createdProfil);
    }

    @GetMapping("/profil")
    public ResponseEntity<List<Profil>> getAllProfils() {
        List<Profil> profil = profilService.getAllProfils();
        return ResponseEntity.ok(profil);
    }

    @GetMapping("/profil/{id}")
    public ResponseEntity<Profil> getProfilById(@PathVariable("id") Long id) {
        Optional<Profil> optionalProfil = profilService.getProfilById(id);
        return optionalProfil.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/profil/{id}")
    public ResponseEntity<Optional<Profil>> updateProfil(@PathVariable("id") Long id, @RequestBody Profil updatedProfil) {
        Optional<Profil> profil = profilService.updateProfil(id, updatedProfil);
        return ResponseEntity.ok(profil);
    }

    @DeleteMapping("/profil/{id}")
    public ResponseEntity<Void> deleteProfil(@PathVariable("id") Long id) {
        profilService.deleteProfil(id);
        return ResponseEntity.noContent().build();
    }
}
