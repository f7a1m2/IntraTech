package labs.intratech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import labs.intratech.models.SupportTicketsStatus;


public interface SupportTicketsStatusRepository extends JpaRepository<SupportTicketsStatus, Long> {
}



