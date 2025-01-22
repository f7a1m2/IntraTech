package labs.intratech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import labs.intratech.models.Postes;


public interface PostesRepository extends JpaRepository<Postes, Long> {
}



