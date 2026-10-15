package tn.esprit.autoloc.autolocapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.autolocapi.domain.Agence;
import tn.esprit.autoloc.autolocapi.service.IAgenceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping ("/agences")
public class AgenceController {
    private final IAgenceService agenceService;

    @GetMapping("/afficher/{id}")
    public  Agence getAgenceById(@PathVariable Long id) {
        return agenceService.afficherAgenceByID(id);


    }

    @GetMapping("/afficherToutesAgences")
    public List<Agence> afficherToutesAgences(){
        return agenceService.afficherToutesAgence();
    }

    @PostMapping("/ajouterAgence")
    public Agence ajouterAgence(@RequestBody Agence agence) {
        return agenceService.ajouterAgence(agence);
    }

    @PutMapping("/modifierAgence")
    public Agence modifierAgence(@RequestBody Agence agence) {
        return agenceService.modifierAgence(agence);
    }

    @DeleteMapping("/DeleteAgence/{idAgence}")
    public void DeleteAgence(@PathVariable Long idAgence) {

        agenceService.supprimerAgence(idAgence);
    }
}
