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
	public SaasProductsService(SaasProductsRepository saasProductsRepository) {
	    this.saasproductsRepository = saasProductsRepository;
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
	    Optional<SaasProducts> existingSaasProducts = saasproductsRepository.findById(id);
	       if (existingSaasProducts.isPresent()) {
		       saasproducts.setSaasProductsid(id);
	             return saasproductsRepository.save(saasproducts);
	       } else {
	          throw new RuntimeException("SaasProducts not found with id " + id);
	       }
	}

	public void deleteSaasProducts(Long id) {
	    saasproductsRepository.deleteById(id);
	}

}



