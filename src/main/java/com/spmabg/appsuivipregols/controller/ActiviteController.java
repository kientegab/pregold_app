package com.spmabg.appsuivipregols.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spmabg.appsuivipregols.entity.Activite;

import com.spmabg.appsuivipregols.service.ActiviteService;
import com.spmabg.appsuivipregols.service.EmailService;

import jakarta.mail.MessagingException;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ActiviteController {
	
	 @Autowired
	private final ActiviteService activiteService;
    private final EmailService emailService; // Inject the EmailService
    
    public ActiviteController(ActiviteService activiteService, EmailService emailService) {
        this.activiteService = activiteService;
        this.emailService = emailService; // Initialize the EmailService
    }
    
    @GetMapping("/activite/{indicateurId}")
    public List<Activite> getActivitesForIndicateur(@PathVariable Long indicateurId) {
        return activiteService.getActivitesForIndicateur(indicateurId);
    }

    @PostMapping("/activite")
    public Activite createActivite(@RequestBody Activite activite) {
        // Call the createActivite method from ActiviteService
        Activite newActivite = activiteService.createActivite(activite);

        // Send a notification email
        String to = "recipient@example.com"; // Specify the recipient's email address
        String subject = "New Activity Added";
        String content = "A new activity has been added: " + newActivite.getLibelle();

        try {
            emailService.sendNotificationEmail(to, subject, content);
        } catch (MessagingException e) {
            // Handle the exception appropriately
            e.printStackTrace();
        }

        return newActivite;
    }

    @GetMapping("/activite")
    public ResponseEntity<List<Activite>> getAllActivites() {
        List<Activite> activites = activiteService.getAllActivites();
        return ResponseEntity.ok(activites);
    }

    @GetMapping("/activite/{id}")
    public ResponseEntity<Activite> getActiviteById(@PathVariable("id") Long id) {
        Optional<Activite> optionalActivite = activiteService.getActiviteById(id);
        return optionalActivite.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/activite/{id}")
    public ResponseEntity<Optional<Activite>> updateActivite(@PathVariable("id") Long id, @RequestBody Activite updatedActivite) {
        Optional<Activite> activite = activiteService.updateActivite(id, updatedActivite);
        return ResponseEntity.ok(activite);
    }
    

    @DeleteMapping("/activite/{id}")
    public ResponseEntity<Void> deleteActivite(@PathVariable("id") Long id) {
        activiteService.deleteActivite(id);
        return ResponseEntity.noContent().build();
    }
}
