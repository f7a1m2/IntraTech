package labs.intratech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import labs.intratech.models.Evaluations;


public interface EvaluationsRepository extends JpaRepository<Evaluations, Long> {
}



