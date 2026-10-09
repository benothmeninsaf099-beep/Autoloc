package tn.esprit.autoloc.autolocapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.autolocapi.domain.Client;

import java.util.List;

@Service
@AllArgsConstructor
public class IClientServiceimp  implements IClientService{
    @Override
    public Client ajouterClient(Client client) {
        return null;
    }

    @Override
    public Client modifierClient(Client client) {
        return null;
    }

    @Override
    public List<Client> afficherTousClients() {
        return List.of();
    }

    @Override
    public Client afficherClientByID(Long id) {
        return null;
    }

    @Override
    public void supprimerClient(Long id) {

    }
}
