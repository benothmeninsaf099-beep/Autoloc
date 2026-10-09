package tn.esprit.autoloc.autolocapi.service;

import tn.esprit.autoloc.autolocapi.domain.Paiement;

import java.util.List;

public class IPaiementServiceimp implements IPaiementService{
    @Override
    public Paiement ajouterPaiement(Paiement paiement) {
        return null;
    }

    @Override
    public Paiement modifierPaiement(Paiement paiement) {
        return null;
    }

    @Override
    public List<Paiement> afficherTousPaiements() {
        return List.of();
    }

    @Override
    public Paiement afficherPaiementByID(Long id) {
        return null;
    }

    @Override
    public void supprimerPaiement(Long id) {

    }
}
