package tn.esprit.autoloc.autolocapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.autolocapi.domain.Employe;
@Repository
public interface EmployeRepository extends JpaRepository<Employe,Long> {

}
