package com.spmabg.appsuivipregols.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Table(name="ministere")
@Entity
public class Ministere {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")

	@JoinColumn(name="ministere_id",nullable = false)
    private Long idMinistere;
    
    private String libelle;
    
    private String sigle;

	public Long getIdMinistere() {
		return idMinistere;
	}

	public void setIdMinistere(Long idMinistere) {
		this.idMinistere = idMinistere;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getSigle() {
		return sigle;
	}

	public void setSigle(String sigle) {
		this.sigle = sigle;
	}

	
    
}