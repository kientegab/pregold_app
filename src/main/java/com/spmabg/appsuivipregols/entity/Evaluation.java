package com.spmabg.appsuivipregols.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="evaluation")
public class Evaluation {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "structure_seq")
    @Column(name = "evaluation_id", nullable = false)
    private int idEvaluation;

    private int  valeur;
    private double poids;
    private double taux;

    public int getIdEvaluation() {
		return idEvaluation;
	}

	public void setIdEvaluation(int idEvaluation) {
		this.idEvaluation = idEvaluation;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public Activite getActivite() {
		return activite;
	}

	public void setActivite(Activite activite) {
		this.activite = activite;
	}

	@ManyToOne(targetEntity = Activite.class)
    @JoinColumn(name = "activite_id", nullable = false)
    private Activite activite;

	
    
    
    
    
    
}
