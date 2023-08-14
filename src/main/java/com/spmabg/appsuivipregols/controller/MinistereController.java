package com.spmabg.appsuivipregols.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spmabg.appsuivipregols.entity.Ministere;

import com.spmabg.appsuivipregols.service.MinistereService;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MinistereController {
	
	@Autowired
    private final MinistereService ministereService;

    
    public MinistereController(MinistereService ministereService) {
        this.ministereService = ministereService;
    }

    @GetMapping("/ministere")
    public List<Ministere> getAllMinisteres() {
        return ministereService.getAllMinisteres();
    }

    @GetMapping("/ministere/{id}")
    public ResponseEntity<Ministere> getMinistereById(@PathVariable("id") Long id) {
        Optional<Ministere> ministere = ministereService.getMinistereById(id);
        return ministere.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/ministere")
    public ResponseEntity<Ministere> createMinistere(@RequestBody Ministere ministere) {
        Ministere createdMinistere = ministereService.createMinistere(ministere);
        if (createdMinistere != null) {
            return ResponseEntity.ok(createdMinistere);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    
    @PutMapping("/ministere/{id}")
    public ResponseEntity<Optional<Ministere>> updateMinistere(@PathVariable("id") Long id, @RequestBody Ministere updatedMinistere) {
        Optional<Ministere> ministere = ministereService.updateMinistere(id, updatedMinistere);
        return ResponseEntity.ok(ministere);
    }

    @DeleteMapping("/ministere/{id}")
    public ResponseEntity<Void> deleteMinistere(@PathVariable("id") Long id) {
    	ministereService.deleteMinistere(id);
            return ResponseEntity.notFound().build();
        }
    
}
