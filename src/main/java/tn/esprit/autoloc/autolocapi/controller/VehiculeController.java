package tn.esprit.autoloc.autolocapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.autolocapi.domain.Vehicule;
import tn.esprit.autoloc.autolocapi.service.IVehiculeService;

import java.util.List;
@Tag(name = "Gestion de vehicule", description = "Crud")

@RestController
@AllArgsConstructor
@RequestMapping("/vehicules")
public class VehiculeController {

    private final IVehiculeService vehiculeService;

    @GetMapping("/afficher/{id}")
    public Vehicule getVehiculeById(@PathVariable Long id) {
        return vehiculeService.afficherVehiculeByID(id);
    }

    @GetMapping("/afficherTousVehicules")
    public List<Vehicule> afficherTousVehicules() {
        return vehiculeService.afficherTousVehicules();
    }
@Operation(summary = "ajouter un contrat")
    @PostMapping("/ajouterVehicule")
    public Vehicule ajouterVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.ajouterVehicule(vehicule);
    }

    @PutMapping("/modifierVehicule")
    public Vehicule modifierVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.modifierVehicule(vehicule);
    }

    @DeleteMapping("/deleteVehicule/{id}")
    public void supprimerVehicule(@PathVariable Long id) {
        vehiculeService.supprimerVehicule(id);
    }
}