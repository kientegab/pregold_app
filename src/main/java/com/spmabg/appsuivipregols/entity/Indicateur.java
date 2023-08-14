package com.spmabg.appsuivipregols.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="indicateur")
public class Indicateur {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "indicateur_seq")
	@JoinColumn(name="indicateur_id",nullable = false)
    private Long idIndicateur;
	
    private String libelle;
    
    private String valeur;

	public Long getIdIndicateur() {
		return idIndicateur;
	}

	public void setIdIndicateur(Long idIndicateur) {
		this.idIndicateur = idIndicateur;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	

	
	
}

