package com.spmabg.appsuivipregols.entity;


import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Table(name="periode")
@Entity
public class Periode {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
	
	@JoinColumn(name="document_id",nullable = false)
	private Long idDocument;
    
	private String libelle;
    
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateDebut;
	
	
	public Long getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(Long idDocument) {
		this.idDocument = idDocument;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public Boolean getOuvert() {
		return ouvert;
	}

	public void setOuvert(Boolean ouvert) {
		this.ouvert = ouvert;
	}

	public Boolean getVerrouiller() {
		return verrouiller;
	}

	public void setVerrouiller(Boolean verrouiller) {
		this.verrouiller = verrouiller;
	}

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateFin;
    
    private Boolean ouvert;
    
    private Boolean verrouiller;
    
    
   
	
}
