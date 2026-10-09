package tn.esprit.autoloc.autolocapi.service;

import tn.esprit.autoloc.autolocapi.domain.Maintenance;

import java.util.List;

public class IMaintenanaceServiceimp implements IMaintenanceService{
    @Override
    public Maintenance ajouterMaintenance(Maintenance maintenance) {
        return null;
    }

    @Override
    public Maintenance modifierMaintenance(Maintenance maintenance) {
        return null;
    }

    @Override
    public List<Maintenance> afficherToutesMaintenances() {
        return List.of();
    }

    @Override
    public Maintenance afficherMaintenanceByID(Long id) {
        return null;
    }

    @Override
    public void supprimerMaintenance(Long id) {

    }
}
