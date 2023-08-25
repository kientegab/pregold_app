package com.spmabg.appsuivipregols.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spmabg.appsuivipregols.entity.ApiResponse;
import com.spmabg.appsuivipregols.entity.Utilisateur;
import com.spmabg.appsuivipregols.service.UtilisateurService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UtilisateurController {
	@Autowired
    private UtilisateurService utilisateurService;

    @PostMapping("/compte")
    public ResponseEntity<ApiResponse> enregistrerUtilisateur(@RequestBody Utilisateur utilisateur) {
        utilisateurService.enregistrerUtilisateur(utilisateur);
        return ResponseEntity.ok(new ApiResponse("success", "Utilisateur enregistré avec succès."));
    }

    @PostMapping("/compte/connexion")
    public ResponseEntity<String> connexion(@RequestBody Map<String, String> credentials) {
        String matricule = credentials.get("matricule");
        String password = credentials.get("password");

        Utilisateur utilisateur = utilisateurService.trouverUtilisateurParMatricule(matricule);

        if (utilisateur != null && utilisateur.getPassword().equals(password)) {
            return ResponseEntity.ok("Connexion réussie.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Matricule ou mot de passe incorrect.");
        }
    }
    
    @GetMapping("/compte")
    public ResponseEntity<List<Utilisateur>> getAllUtilisateurs() {
        List<Utilisateur> utilisateurs= utilisateurService.getAllUtilisateurs();
        return ResponseEntity.ok(utilisateurs);
    }
    
    
    @GetMapping("/compte/{id}/fullname")
    public ResponseEntity<String> getNomCompletUtilisateur(@PathVariable Long id) {
        try {
            String nomComplet = utilisateurService.getNomCompletUtilisateur(id);
            return ResponseEntity.ok(nomComplet);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/compte/{id}")
    public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable("id") Long id) {
        Optional<Utilisateur> optionalUtilisateur = utilisateurService.getUtilisateurById(id);
        return optionalUtilisateur.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    
    

    @PutMapping("/compte/{id}")
    public ResponseEntity<Optional<Utilisateur>> updateUtilisateur(@PathVariable("id") Long id, @RequestBody Utilisateur updatedUtilisateur) {
        Optional<Utilisateur> utilisateur = utilisateurService.updateUtilisateur(id, updatedUtilisateur);
        return ResponseEntity.ok(utilisateur);
    }

    @DeleteMapping("/compte/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable("id") Long id) {
    	utilisateurService.deleteUtilisateur(id);
        return ResponseEntity.noContent().build();
    }
}
