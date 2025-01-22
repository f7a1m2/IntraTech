package labs.intratech.services;

import labs.intratech.models.SaasProducts;
import org.springframework.stereotype.Service;
import labs.intratech.repositories.SaasProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class SaasProductsService  {
	private final SaasProductsRepository saasProductsRepository;

	@Autowired
	public SaasProductsService(SaasProductsRepository saasProductsRepository, SaasProductsRepository saasProductsRepository1) {
        this.saasProductsRepository = saasProductsRepository1;
	}

	public List<SaasProducts> getAllSaasProducts() {
	    return saasProductsRepository.findAll();
	}  

	public SaasProducts getSaasProductsById(Long id) {
	    Optional<SaasProducts> saasProducts = saasProductsRepository.findById(id);
	    if (saasProducts.isPresent()) {
	       return saasProducts.get();
	    } else {
	       throw new RuntimeException("SaasProducts not found with id " + id);
	    }
	}

	public SaasProducts createSaasProducts(SaasProducts saasProducts) {
	    return saasProductsRepository.save(saasProducts);
	}

	public SaasProducts updateSaasProducts(Long id, SaasProducts saasproducts) {
	    Optional<SaasProducts> existingSaasProducts = saasProductsRepository.findById(id);
	       if (existingSaasProducts.isPresent()) {
		       saasproducts.setId(id);
	             return saasProductsRepository.save(saasproducts);
	       } else {
	          throw new RuntimeException("SaasProducts not found with id " + id);
	       }
	}

	public void deleteSaasProducts(Long id) {
		saasProductsRepository.deleteById(id);
	}

}



