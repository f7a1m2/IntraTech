package labs.intratech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import labs.intratech.models.Employes;


public interface EmployesRepository extends JpaRepository<Employes, Long> {
}



