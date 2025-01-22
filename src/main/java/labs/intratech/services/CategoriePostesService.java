package labs.intratech.services;

import labs.intratech.models.CategoriePostes;
import org.springframework.stereotype.Service;
import labs.intratech.repositories.CategoriePostesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriePostesService  {
	private final CategoriePostesRepository categoriePostesRepository;

	@Autowired
	public CategoriePostesService(CategoriePostesRepository categoriePostesRepository) {
	    this.categoriepostesRepository = categoriePostesRepository;
	}

	public List<CategoriePostes> getAllCategoriePostes() {
	    return categoriePostesRepository.findAll();
	}  

	public CategoriePostes getCategoriePostesById(Long id) {
	    Optional<CategoriePostes> categoriePostes = categoriePostesRepository.findById(id);
	    if (categoriePostes.isPresent()) {
	       return categoriePostes.get();
	    } else {
	       throw new RuntimeException("CategoriePostes not found with id " + id);
	    }
	}

	public CategoriePostes createCategoriePostes(CategoriePostes categoriePostes) {
	    return categoriePostesRepository.save(categoriePostes);
	}

	public CategoriePostes updateCategoriePostes(Long id, CategoriePostes categoriepostes) {
	    Optional<CategoriePostes> existingCategoriePostes = categoriepostesRepository.findById(id);
	       if (existingCategoriePostes.isPresent()) {
		       categoriepostes.setCategoriePostesid(id);
	             return categoriepostesRepository.save(categoriepostes);
	       } else {
	          throw new RuntimeException("CategoriePostes not found with id " + id);
	       }
	}

	public void deleteCategoriePostes(Long id) {
	    categoriepostesRepository.deleteById(id);
	}

}



