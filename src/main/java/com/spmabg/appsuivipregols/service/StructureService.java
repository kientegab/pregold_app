package com.spmabg.appsuivipregols.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spmabg.appsuivipregols.entity.Structure;
import com.spmabg.appsuivipregols.repository.StructureRepository;

@Service
public class StructureService {
	@Autowired
    private final StructureRepository structureRepository;
    
    
    public StructureService(StructureRepository structureRepository) {
        this.structureRepository = structureRepository;
    }

    public Structure createStructure(Structure structure) {
        return structureRepository.save(structure);
    }

    public List<Structure> getAllStructures() {
        return structureRepository.findAll();
    }

    public Optional<Structure> getStructureById(Long id) {
        return structureRepository.findById(id);
    }

    public Optional<Structure> updateStructure(Long id, Structure updatedStructure) {
        Optional<Structure> optionalStructure = structureRepository.findById(id);
        if (optionalStructure.isPresent()) {
            Structure structure = optionalStructure.get();
            structure.setLibelle(updatedStructure.getLibelle());
            structure.setSigle(updatedStructure.getSigle());
            return Optional.of(structureRepository.save(structure));
        } else {
        	return Optional.empty();
        }
    }

    public void deleteStructure(Long id) {
        Optional<Structure> optionalStructure = structureRepository.findById(id);
        if (optionalStructure.isPresent()) {
            structureRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Structure not found");
        }
    }

}
