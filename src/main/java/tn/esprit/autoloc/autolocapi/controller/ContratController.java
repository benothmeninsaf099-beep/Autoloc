package tn.esprit.autoloc.autolocapi.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.autolocapi.domain.Contrat;
import tn.esprit.autoloc.autolocapi.service.IContratService;

import java.util.List;
@Tag(name = "Gestion de contrat", description = "Crud")
@RestController
@AllArgsConstructor
@RequestMapping("/contrats")
public class ContratController {

    private final IContratService contratService;

    @GetMapping("/afficher/{id}")
    public Contrat getContratById(@PathVariable Long id) {
        return contratService.afficherContratByID(id);
    }

    @GetMapping("/afficherTousContrats")
    public List<Contrat> afficherTousContrats() {
        return contratService.afficherToutesContrat();
    }

    @PostMapping("/ajouterContrat")
    public Contrat ajouterContrat(@RequestBody Contrat contrat) {
        return contratService.ajouterContrat(contrat);
    }

    @PutMapping("/modifierContrat")
    public Contrat modifierContrat(@RequestBody Contrat contrat) {
        return contratService.modifierContrat(contrat);
    }

    @DeleteMapping("/deleteContrat/{id}")
    public void supprimerContrat(@PathVariable Long id) {
        contratService.supprimerContrat(id);
    }
}