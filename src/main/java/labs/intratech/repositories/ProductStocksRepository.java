package labs.intratech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import labs.intratech.models.ProductStocks;


public interface ProductStocksRepository extends JpaRepository<ProductStocks, Long> {
}



