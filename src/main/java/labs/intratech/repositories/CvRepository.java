package labs.intratech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import labs.intratech.models.Cv;


public interface CvRepository extends JpaRepository<Cv, Long> {
}



