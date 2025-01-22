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
	public CategoriePostesService(CategoriePostesRepository categoriePostesRepository, CategoriePostesRepository categoriePostesRepository1) {
        this.categoriePostesRepository = categoriePostesRepository1;
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
	    Optional<CategoriePostes> existingCategoriePostes = categoriePostesRepository.findById(id);
	       if (existingCategoriePostes.isPresent()) {
		       categoriepostes.setId(id);
	             return categoriePostesRepository.save(categoriepostes);
	       } else {
	          throw new RuntimeException("CategoriePostes not found with id " + id);
	       }
	}

	public void deleteCategoriePostes(Long id) {
		categoriePostesRepository.deleteById(id);
	}

}



