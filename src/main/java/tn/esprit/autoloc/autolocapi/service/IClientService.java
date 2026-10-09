package tn.esprit.autoloc.autolocapi.service;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.autolocapi.domain.Client;
import java.util.List;

public interface IClientService {

    Client ajouterClient(Client client);
    Client modifierClient(Client client);
    List<Client> afficherTousClients();
    Client afficherClientByID(Long id);
    void supprimerClient(Long id);
}