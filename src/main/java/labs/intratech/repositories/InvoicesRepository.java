package labs.intratech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import labs.intratech.models.Invoices;


public interface InvoicesRepository extends JpaRepository<Invoices, Long> {
}



