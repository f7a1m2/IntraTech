package labs.intratech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import labs.intratech.models.SupportTickets;


public interface SupportTicketsRepository extends JpaRepository<SupportTickets, Long> {
}



