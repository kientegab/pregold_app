package com.spmabg.appsuivipregols.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spmabg.appsuivipregols.entity.Document;

import com.spmabg.appsuivipregols.repository.DocumentRepository;

@Service
public class DocumentService {
	@Autowired
	private final DocumentRepository documentRepository;

    
    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    public Optional<Document> getDocumentById(Long id) {
        return documentRepository.findById(id);
    }

    public Document createDocument(Document document) {
        return documentRepository.save(document);
    }

    public Optional<Document> updateIndicateurDocument(Long id, Document updatedDocument) {
        Optional<Document> optionalDocument = documentRepository.findById(id);
        if (optionalDocument.isPresent()) {
        	Document document = optionalDocument.get();
        	document.setLibelle(updatedDocument.getLibelle());
        	document.setDescription(updatedDocument.getDescription());
        	document.setStatus(updatedDocument.getStatus());
        	document.setChemin(updatedDocument.getChemin());
        	document.setType(updatedDocument.getType());
        	document.setFormat(updatedDocument.getFormat());
            return Optional.of(documentRepository.save(document));
        } else {
        	throw new IllegalArgumentException("Document not found");
        }
    }

    public void deleteDocument(Long id) {
        Optional<Document> optionalDocument = documentRepository.findById(id);
        if (optionalDocument.isPresent()) {
        	documentRepository.deleteById(id);
            
        } else {
        	throw new IllegalArgumentException("Document not found");
        }
    }
}
