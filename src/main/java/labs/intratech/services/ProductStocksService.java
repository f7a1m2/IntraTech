package labs.intratech.services;

import labs.intratech.models.ProductStocks;
import org.springframework.stereotype.Service;
import labs.intratech.repositories.ProductStocksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class ProductStocksService  {
	private final ProductStocksRepository productStocksRepository;

	@Autowired
	public ProductStocksService(ProductStocksRepository productStocksRepository) {
	    this.productstocksRepository = productStocksRepository;
	}

	public List<ProductStocks> getAllProductStocks() {
	    return productStocksRepository.findAll();
	}  

	public ProductStocks getProductStocksById(Long id) {
	    Optional<ProductStocks> productStocks = productStocksRepository.findById(id);
	    if (productStocks.isPresent()) {
	       return productStocks.get();
	    } else {
	       throw new RuntimeException("ProductStocks not found with id " + id);
	    }
	}

	public ProductStocks createProductStocks(ProductStocks productStocks) {
	    return productStocksRepository.save(productStocks);
	}

	public ProductStocks updateProductStocks(Long id, ProductStocks productstocks) {
	    Optional<ProductStocks> existingProductStocks = productstocksRepository.findById(id);
	       if (existingProductStocks.isPresent()) {
		       productstocks.setProductStocksid(id);
	             return productstocksRepository.save(productstocks);
	       } else {
	          throw new RuntimeException("ProductStocks not found with id " + id);
	       }
	}

	public void deleteProductStocks(Long id) {
	    productstocksRepository.deleteById(id);
	}

}



