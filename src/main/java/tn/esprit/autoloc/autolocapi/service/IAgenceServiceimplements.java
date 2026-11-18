package tn.esprit.autoloc.autolocapi.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.autolocapi.domain.Agence;
import tn.esprit.autoloc.autolocapi.repository.AgenceRepository;
import tn.esprit.autoloc.autolocapi.repository.VehiculeRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class IAgenceServiceimplements implements IAgenceService {
private final AgenceRepository agenceRepository;
    private final VehiculeRepository vehiculeRepository;
    @Override
    public Agence ajouterAgence(Agence agence) {
        return agenceRepository.save(agence)   ;
    }

    @Override
    public Agence modifierAgence(Agence agence) {
        return  agenceRepository.save(agence);
    }

    @Override
    public List<Agence> afficherToutesAgence() {
        return agenceRepository.findAll();
    }

    @Override
    public Agence afficherAgenceByID(Long id) {
        return agenceRepository.findById(id).orElse(null);}

    @Override
    public void supprimerAgence(Long id) {
         agenceRepository.deleteById(id);

    }
    @Override
    @Transactional
    public Agence ajouterAgenceEtAffecterVehicules(Agence agence) {
        agenceRepository.save(agence);
        agence.getVehicules().forEach(vehicule -> {
                    vehicule.setAgence(agence);
                    vehiculeRepository.save(vehicule);
                }
        );
        return agence;
    }
    @Scheduled(fixedDelay = 2, timeUnit = TimeUnit.MINUTES)
    public void suivreNombreAgences() {
        List<Agence> agences = agenceRepository.findAll();
        System.out.println("===== Suivi des agences =====");
        System.out.println("Nombre total d'agences : " + agences.size());
        System.out.println("Date et heure de la vérification : " + LocalDateTime.now());
    }
}
