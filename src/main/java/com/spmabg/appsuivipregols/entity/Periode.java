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

	private Long idPeriode;
    
	private String libelle;
    
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateDebut;
	
	
	public Long getIdPeriode() {
		return idPeriode;
	}

	public void setIdPeriode(Long idPeriode) {
		this.idPeriode = idPeriode;
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

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateFin;
    
    
    
    
   
	
}
