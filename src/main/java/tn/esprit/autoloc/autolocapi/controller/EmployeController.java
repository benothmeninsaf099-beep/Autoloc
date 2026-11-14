package tn.esprit.autoloc.autolocapi.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.autolocapi.domain.Employe;
import tn.esprit.autoloc.autolocapi.service.IEmployeService;

import java.util.List;
@Tag(name = "Gestion de Employe", description = "Crud")
@RestController
@AllArgsConstructor
@RequestMapping("/employes")
public class EmployeController {

    private final IEmployeService employeService;

    @GetMapping("/afficher/{id}")
    public Employe getEmployeById(@PathVariable Long id) {
        return employeService.afficherEmployeByID(id);
    }

    @GetMapping("/afficherTousEmployes")
    public List<Employe> afficherTousEmployes() {
        return employeService.afficherTousEmployes();
    }

    @PostMapping("/ajouterEmploye")
    public Employe ajouterEmploye(@RequestBody Employe employe) {
        return employeService.ajouterEmploye(employe);
    }

    @PutMapping("/modifierEmploye")
    public Employe modifierEmploye(@RequestBody Employe employe) {
        return employeService.modifierEmploye(employe);
    }

    @DeleteMapping("/deleteEmploye/{id}")
    public void supprimerEmploye(@PathVariable Long id) {
        employeService.supprimerEmploye(id);
    }
    @PutMapping("/desaffecterEmploye/{idEmploye}")
    public Employe desaffecterEmploye(@PathVariable Long idEmploye) {
        return employeService.desaffecterEmploye(idEmploye);
    }

    @PutMapping("/affecterEmployeAgence/{idEmploye}/{idAgence}")
    public Employe affecterEmployeAgence(@PathVariable Long idEmploye, @PathVariable Long idAgence) {
        return employeService.affecterEmploye(idEmploye, idAgence);
    }
}