package labs.intratech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import labs.intratech.models.FinancialIndicators;


public interface FinancialIndicatorsRepository extends JpaRepository<FinancialIndicators, Long> {
}



