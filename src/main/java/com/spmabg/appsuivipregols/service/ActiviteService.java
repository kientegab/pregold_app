package com.spmabg.appsuivipregols.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spmabg.appsuivipregols.entity.Activite;

import com.spmabg.appsuivipregols.entity.Notification;
import com.spmabg.appsuivipregols.repository.ActiviteRepository;
import com.spmabg.appsuivipregols.repository.NotificationRepository;

import jakarta.mail.MessagingException;

@Service
public class ActiviteService {
	@Autowired
	 	private final ActiviteRepository activiteRepository;
	    private final NotificationRepository notificationRepository;
	    private final EmailService emailService;

	    
	    public ActiviteService(
	            ActiviteRepository activiteRepository,
	            NotificationRepository notificationRepository,
	            EmailService emailService
	    ) {
	        this.activiteRepository = activiteRepository;
	        this.notificationRepository = notificationRepository; 
	        this.emailService =emailService;
	    }

	    public Activite createActivite(Activite activite) {
	        Activite newActivite = activiteRepository.save(activite);
	        
	        Notification notification = new Notification();
	        notification.setObjet("Nouvelle activité ajoutée");
	        notification.setContenu("Une nouvelle activité a été ajoutée : " + newActivite.getLibelle());
	        notification.setDestination("ouedwendedith@gmail.com");  
	        
	        notificationRepository.save(notification);  
	        
	        String to = "ouedwendedith@gmail.com"; 
	        String subject = "Nouvelle activité ajoutée";
	        String content = "Une nouvelle activité a été ajoutée : " + newActivite.getLibelle();

	        try {
	            emailService.sendNotificationEmail(to, subject, content);
	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }

	        return newActivite;
	    }

    public List<Activite> getAllActivites() {
        return activiteRepository.findAll();
    }

    public Optional<Activite> getActiviteById(Long id) {
        return activiteRepository.findById(id);
    }
    
    public List<Activite> getActivitesForIndicateur(Long indicateurId) {
        return activiteRepository.findByIndicateurId(indicateurId);
    }

    public Optional<Activite> updateActivite(Long id, Activite updatedActivite) {
        Optional<Activite> optionalActivite = activiteRepository.findById(id);
        if (optionalActivite.isPresent()) {
            Activite activite = optionalActivite.get();
            activite.setLibelle(updatedActivite.getLibelle());
            activite.setIndicateur(updatedActivite.getIndicateur());
            activite.setLieu(updatedActivite.getLieu());
            activite.setDateDebut(updatedActivite.getDateDebut());
            activite.setDateFin(updatedActivite.getDateFin());
            activite.setNombreparticipant(updatedActivite.getNombreparticipant());
            activite.setDescription(updatedActivite.getDescription());
            activite.setSible(updatedActivite.getSible());
            
            return Optional.of(activiteRepository.save(activite));
        } else {
            throw new IllegalArgumentException("Activite not found");
        }
    }

    public void deleteActivite(Long id) {
        Optional<Activite> optionalActivite = activiteRepository.findById(id);
        if (optionalActivite.isPresent()) {
            activiteRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Activite not found");
        }
    }
}
