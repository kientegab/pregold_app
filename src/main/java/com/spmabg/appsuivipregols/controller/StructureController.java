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

import com.spmabg.appsuivipregols.entity.Structure;
import com.spmabg.appsuivipregols.service.StructureService;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class StructureController {
	 @Autowired
    private final StructureService structureService;
   
    public StructureController(StructureService structureService) {
        this.structureService = structureService;
    }

    @PostMapping("/structure")
    public ResponseEntity<Structure> createStructure(@RequestBody Structure structure) {
        Structure createdStructure = structureService.createStructure(structure);
        return ResponseEntity.ok(createdStructure);
    }

    @GetMapping("/structure")
    public ResponseEntity<List<Structure>> getAllStructures() {
        List<Structure> structures = structureService.getAllStructures();
        return ResponseEntity.ok(structures);
    }

    @GetMapping("/structure/{id}")
    public ResponseEntity<Structure> getStructureById(@PathVariable("id") Long id) {
        Optional<Structure> optionalStructure = structureService.getStructureById(id);
        return optionalStructure.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/structure/{id}")
    public ResponseEntity<Optional<Structure>> updateStructure(@PathVariable("id") Long id, @RequestBody Structure updatedStructure) {
        Optional<Structure> structure = structureService.updateStructure(id, updatedStructure);
        return ResponseEntity.ok(structure);
    }

    @DeleteMapping("/structure/{id}")
    public ResponseEntity<Void> deleteStructure(@PathVariable("id") Long id) {
        structureService.deleteStructure(id);
        return ResponseEntity.noContent().build();
    }
}
