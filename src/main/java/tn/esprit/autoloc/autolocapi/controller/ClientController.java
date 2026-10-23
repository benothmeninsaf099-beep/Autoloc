package tn.esprit.autoloc.autolocapi.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.autolocapi.domain.Client;
import tn.esprit.autoloc.autolocapi.service.IClientService;

import java.util.List;
@Tag(name = "Gestion de client", description = "Crud")
@RestController
@AllArgsConstructor
@RequestMapping("/clients")
public class ClientController {

    private final IClientService clientService;

    @GetMapping("/afficher/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.afficherClientByID(id);
    }

    @GetMapping("/afficherTousClients")
    public List<Client> afficherTousClients() {
        return clientService.afficherTousClients();
    }

    @PostMapping("/ajouterClient")
    public Client ajouterClient(@RequestBody Client client) {
        return clientService.ajouterClient(client);
    }

    @PutMapping("/modifierClient")
    public Client modifierClient(@RequestBody Client client) {
        return clientService.modifierClient(client);
    }

    @DeleteMapping("/deleteClient/{id}")
    public void supprimerClient(@PathVariable Long id) {
        clientService.supprimerClient(id);
    }
}