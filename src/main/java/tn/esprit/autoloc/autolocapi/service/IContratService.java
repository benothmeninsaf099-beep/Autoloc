package tn.esprit.autoloc.autolocapi.service;

import tn.esprit.autoloc.autolocapi.domain.Agence;
import tn.esprit.autoloc.autolocapi.domain.Contrat;

import java.util.List;

public interface IContratService {
    Contrat ajouterContrat(Contrat contrat);
    Contrat modifierContrat (Contrat contrat);
    List<Contrat> afficherToutesContrat();
    Contrat afficherContratByID (Long id);
    void supprimerContrat(Long id);
}
