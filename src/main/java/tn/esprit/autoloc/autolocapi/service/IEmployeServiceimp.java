
package tn.esprit.autoloc.autolocapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.autolocapi.domain.Agence;
import tn.esprit.autoloc.autolocapi.domain.Employe;
import tn.esprit.autoloc.autolocapi.repository.AgenceRepository;
import tn.esprit.autoloc.autolocapi.repository.EmployeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class IEmployeServiceimp implements IEmployeService {

    private final EmployeRepository employeRepository;
    private final AgenceRepository agenceRepository;
    @Override
    public Employe ajouterEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe modifierEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public List<Employe> afficherTousEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public Employe afficherEmployeByID(Long id) {
        return employeRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerEmploye(Long id) {
        employeRepository.deleteById(id);
    }
    @Override

    public Employe desaffecterEmploye(Long idEmploye) {
        Employe employe = employeRepository.findById(idEmploye).get();
        employe.setAgence(null);
        return employeRepository.save(employe);
    }

    @Override

    public Employe affecterEmploye(Long idEmploye, Long idAgence) {
        Employe employe = employeRepository.findById(idEmploye).get();
        Agence agence = agenceRepository.findById(idAgence).get();
        employe.setAgence(agence);
        return employeRepository.save(employe);
    }
}
