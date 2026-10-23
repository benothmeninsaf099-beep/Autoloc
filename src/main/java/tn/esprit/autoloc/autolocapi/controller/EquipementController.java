package tn.esprit.autoloc.autolocapi.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.autolocapi.domain.Equipement;
import tn.esprit.autoloc.autolocapi.service.IEquipementService;

import java.util.List;
@Tag(name = "Gestion de Equipement", description = "Crud")
@RestController
@AllArgsConstructor
@RequestMapping("/equipements")
public class EquipementController {

    private final IEquipementService equipementService;

    @GetMapping("/afficher/{id}")
    public Equipement getEquipementById(@PathVariable Long id) {
        return equipementService.afficherEquipementByID(id);
    }

    @GetMapping("/afficherTousEquipements")
    public List<Equipement> afficherTousEquipements() {
        return equipementService.afficherTousEquipements();
    }

    @PostMapping("/ajouterEquipement")
    public Equipement ajouterEquipement(@RequestBody Equipement equipement) {
        return equipementService.ajouterEquipement(equipement);
    }

    @PutMapping("/modifierEquipement")
    public Equipement modifierEquipement(@RequestBody Equipement equipement) {
        return equipementService.modifierEquipement(equipement);
    }

    @DeleteMapping("/deleteEquipement/{id}")
    public void supprimerEquipement(@PathVariable Long id) {
        equipementService.supprimerEquipement(id);
    }
}