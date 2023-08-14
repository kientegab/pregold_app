package com.spmabg.appsuivipregols.entity;


import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="activite")
public class Activite {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "activite_seq")
    private Long idActivite;
    
    private String libelle;
	private String lieu;
   
    private Long nombreparticipant;
    
    private String description;
     
    private Number sible;
    
   
    
    public Long getIdActivite() {
		return idActivite;
	}

	public void setIdActivite(Long idActivite) {
		this.idActivite = idActivite;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public Long getNombreparticipant() {
		return nombreparticipant;
	}

	public void setNombreparticipant(Long nombreparticipant) {
		this.nombreparticipant = nombreparticipant;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Number getSible() {
		return sible;
	}

	public void setSible(Number sible) {
		this.sible = sible;
	}

	

	public Indicateur getIndicateur() {
		return indicateur;
	}

	public void setIndicateur(Indicateur indicateur) {
		this.indicateur = indicateur;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Structure getStructure() {
		return structure;
	}

	public void setStructure(Structure structure) {
		this.structure = structure;
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

	@ManyToOne(targetEntity = Indicateur.class)
	@JoinColumn(name="indicateur_id",nullable = false)
    private Indicateur indicateur;
    
    @OneToOne(targetEntity = Document.class)
	@JoinColumn(name="document_id",nullable = false)
    private Document document;
    
    @OneToOne(targetEntity = Structure.class)
   	@JoinColumn(name="structure_id",nullable = false)
    private Structure structure;
    
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateDebut;
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateFin;


	


	

	
}