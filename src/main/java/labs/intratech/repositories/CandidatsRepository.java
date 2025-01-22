package labs.intratech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import labs.intratech.models.Candidats;


public interface CandidatsRepository extends JpaRepository<Candidats, Long> {
}



