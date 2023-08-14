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

import com.spmabg.appsuivipregols.entity.Document;

import com.spmabg.appsuivipregols.service.DocumentService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DocumentController {
	@Autowired
    private final DocumentService documentService;

    
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/document")
    public List<Document> getAllDocuments() {
        return documentService.getAllDocuments();
    }

    @GetMapping("/document/{id}")
    public ResponseEntity<Document> getDocumentById(@PathVariable("id") Long id) {
        Optional<Document> document = documentService.getDocumentById(id);
        return document.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/document")
    public ResponseEntity<Document> createDocument(@RequestBody Document document) {
    	Document createdDocument = documentService.createDocument(document);
        if (createdDocument != null) {
            return ResponseEntity.ok(createdDocument);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    
    @PutMapping("/document/{id}")
    public ResponseEntity<Document> updateDocument(@PathVariable("id") Long id, @RequestBody Document documentData) {
    	Optional<Document> optionalDocument = documentService.getDocumentById(id);
        return optionalDocument.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/document/{id}")
    public ResponseEntity<Void> deleteDocument(@PathVariable("id") Long id) {
    	documentService.deleteDocument(id);
            return ResponseEntity.notFound().build();
        }
    
}
