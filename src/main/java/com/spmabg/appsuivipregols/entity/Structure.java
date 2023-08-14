package com.spmabg.appsuivipregols.entity;




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
@Table(name="structure")
public class Structure {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "structure_seq")
	@JoinColumn(name="structure_id",nullable = false)
	private Long idStructure;
	
    private String libelle;
    private String sigle;
    

    @ManyToOne(targetEntity = Ministere.class)
	@JoinColumn(name="ministere_id",nullable = false)
    
    private Ministere ministere;

	public Long getIdStructure() {
		return idStructure;
	}


	public void setIdStructure(Long idStructure) {
		this.idStructure = idStructure;
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


	public Ministere getMinistere() {
		return ministere;
	}


	public void setMinistere(Ministere ministere) {
		this.ministere = ministere;
	}

	

}