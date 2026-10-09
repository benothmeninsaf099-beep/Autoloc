package tn.esprit.autoloc.autolocapi.service;

import tn.esprit.autoloc.autolocapi.domain.Equipement;
import java.util.List;

public interface IEquipementService {

    Equipement ajouterEquipement(Equipement equipement);

    Equipement modifierEquipement(Equipement equipement);

    List<Equipement> afficherTousEquipements();

    Equipement afficherEquipementByID(Long id);

    void supprimerEquipement(Long id);
}