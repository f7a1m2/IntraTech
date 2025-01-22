package labs.intratech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import labs.intratech.models.Education;


public interface EducationRepository extends JpaRepository<Education, Long> {
}



