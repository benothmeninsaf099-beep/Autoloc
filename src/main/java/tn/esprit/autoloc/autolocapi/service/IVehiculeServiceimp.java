
package tn.esprit.autoloc.autolocapi.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.autolocapi.domain.Equipement;
import tn.esprit.autoloc.autolocapi.domain.Vehicule;
import tn.esprit.autoloc.autolocapi.repository.EquipementRepository;
import tn.esprit.autoloc.autolocapi.repository.VehiculeRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class IVehiculeServiceimp implements IVehiculeService {

    private final VehiculeRepository vehiculeRepository;
    private final EquipementRepository equipementRepository;

    @Override
    public Vehicule ajouterVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule modifierVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public List<Vehicule> afficherTousVehicules() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule afficherVehiculeByID(Long id) {
        return vehiculeRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerVehicule(Long id) {
        vehiculeRepository.deleteById(id);
    }
    @Override
    @Transactional
    public Vehicule affecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule).get();
        Equipement equipement = equipementRepository.findById(idEquipement).get();
        // Côté parent choisi (Vehicule)
        vehicule.getEquipements().add(equipement);
        return vehiculeRepository.save(vehicule);
    }

    @Override
    @Transactional
    public Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule).get();
        Equipement equipement = equipementRepository.findById(idEquipement).get();
        // On enlève le fils du parent
        vehicule.getEquipements().remove(equipement);
        return vehiculeRepository.save(vehicule);
    }
    @Scheduled(initialDelay = 5000, fixedRate = 60000)
    public void actualiserEtatVehicules() {
        List<Vehicule> vehicules = vehiculeRepository.findAll();
        System.out.println("===== Actualisation des véhicules =====");
        System.out.println("Nombre total de véhicules : " + vehicules.size());
        System.out.println("Date et heure de l'actualisation : " + LocalDateTime.now());
    }
    @Scheduled(cron = "0 30 16 * * WED")
    public void genererRapportVehicules() {
        List<Vehicule> vehicules = vehiculeRepository.findAll();
        int total = vehicules.size();
        System.out.println("========== RAPPORT HEBDOMADAIRE DES VÉHICULES ==========");
        System.out.println("Nombre total de véhicules : " + total);
        System.out.println("Date et heure de génération : " + LocalDateTime.now());
        System.out.println("=========================================================");
    }
}
