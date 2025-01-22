package labs.intratech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import labs.intratech.models.InvoiceStatus;


public interface InvoiceStatusRepository extends JpaRepository<InvoiceStatus, Long> {
}



