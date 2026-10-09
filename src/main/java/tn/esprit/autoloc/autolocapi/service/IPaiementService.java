package tn.esprit.autoloc.autolocapi.service;

import tn.esprit.autoloc.autolocapi.domain.Paiement;
import java.util.List;

public interface IPaiementService {

    Paiement ajouterPaiement(Paiement paiement);

    Paiement modifierPaiement(Paiement paiement);

    List<Paiement> afficherTousPaiements();

    Paiement afficherPaiementByID(Long id);

    void supprimerPaiement(Long id);
}