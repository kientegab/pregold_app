package com.spmabg.appsuivipregols.entity;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="evaluation")
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String date;
    private double valeur_activite;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getValeur_activite() {
		return valeur_activite;
	}

	public void setValeur_activite(double valeur_activite) {
		this.valeur_activite = valeur_activite;
	}

	public double getTaux_activite() {
		return taux_activite;
	}

	public void setTaux_activite(double taux_activite) {
		this.taux_activite = taux_activite;
	}

	public String getStatut_activite() {
		return statut_activite;
	}

	public void setStatut_activite(String statut_activite) {
		this.statut_activite = statut_activite;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public List<String> getActivites() {
		return activites;
	}

	public void setActivites(List<String> activites) {
		this.activites = activites;
	}

	private double taux_activite;
    private String statut_activite;
    private String observation;
    
    @ElementCollection
    @CollectionTable(name = "evaluation_activites", joinColumns = @JoinColumn(name = "evaluation_id"))
    @Column(name = "activite")
    private List<String> activites;
    
    
    
    
    
}


