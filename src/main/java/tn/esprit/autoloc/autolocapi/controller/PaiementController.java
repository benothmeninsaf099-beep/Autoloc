package tn.esprit.autoloc.autolocapi.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.autolocapi.domain.Paiement;
import tn.esprit.autoloc.autolocapi.service.IPaiementService;

import java.util.List;
@Tag(name = "Gestion de paiement", description = "Crud")
@RestController
@AllArgsConstructor
@RequestMapping("/paiements")
public class PaiementController {

    private final IPaiementService paiementService;

    @GetMapping("/afficher/{id}")
    public Paiement getPaiementById(@PathVariable Long id) {
        return paiementService.afficherPaiementByID(id);
    }

    @GetMapping("/afficherTousPaiements")
    public List<Paiement> afficherTousPaiements() {
        return paiementService.afficherTousPaiements();
    }

    @PostMapping("/ajouterPaiement")
    public Paiement ajouterPaiement(@RequestBody Paiement paiement) {
        return paiementService.ajouterPaiement(paiement);
    }

    @PutMapping("/modifierPaiement")
    public Paiement modifierPaiement(@RequestBody Paiement paiement) {
        return paiementService.modifierPaiement(paiement);
    }

    @DeleteMapping("/deletePaiement/{id}")
    public void supprimerPaiement(@PathVariable Long id) {
        paiementService.supprimerPaiement(id);
    }
}