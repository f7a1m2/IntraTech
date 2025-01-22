package labs.intratech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import labs.intratech.models.SaasProducts;


public interface SaasProductsRepository extends JpaRepository<SaasProducts, Long> {
}



