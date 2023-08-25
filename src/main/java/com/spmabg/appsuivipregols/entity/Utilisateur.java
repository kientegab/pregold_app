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
@Table(name="utilisateur")
public class Utilisateur {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 	private String matricule;
	    private String nom;
	    private String prenom;
	    private String email;
	    
	    public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getMatricule() {
			return matricule;
		}

		public void setMatricule(String matricule) {
			this.matricule = matricule;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Structure getStructure() {
			return structure;
		}

		public void setStructure(Structure structure) {
			this.structure = structure;
		}

		public Profil getProfil() {
			return profil;
		}

		public void setProfil(Profil profil) {
			this.profil = profil;
		}

		private String password;
	    
	    @ManyToOne(targetEntity = Structure.class)
		@JoinColumn(name="structure_id",nullable = false)
	    private Structure structure;
	    
	    @ManyToOne(targetEntity = Profil.class)
		@JoinColumn(name="profil_id",nullable = true)
	    private Profil profil;
	    
}
