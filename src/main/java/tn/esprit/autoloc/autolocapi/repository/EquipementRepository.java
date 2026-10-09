package tn.esprit.autoloc.autolocapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.autolocapi.domain.Equipement;
@Repository
public interface EquipementRepository extends JpaRepository<Equipement,Long> {
}
