package tn.esprit.autoloc.autolocapi.service;

import tn.esprit.autoloc.autolocapi.domain.Reservation;

import java.util.List;

public class IReservationServiceimp implements IReservationService{
    @Override
    public Reservation ajouterReservation(Reservation reservation) {
        return null;
    }

    @Override
    public Reservation modifierReservation(Reservation reservation) {
        return null;
    }

    @Override
    public List<Reservation> afficherToutesReservations() {
        return List.of();
    }

    @Override
    public Reservation afficherReservationByID(Long id) {
        return null;
    }

    @Override
    public void supprimerReservation(Long id) {

    }
}
