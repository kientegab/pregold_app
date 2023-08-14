package com.spmabg.appsuivipregols.entity;


//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Profil")
public class Profil {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name="profil_id",nullable = false)
    private Long idProfil;
	
    private String libelle;
    //@Column(name = "code", length = 6, unique = true)
    private String code;
	public Long getIdProfil() {
		return idProfil;
	}
	public void setIdProfil(Long idProfil) {
		this.idProfil = idProfil;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
    
    
}
