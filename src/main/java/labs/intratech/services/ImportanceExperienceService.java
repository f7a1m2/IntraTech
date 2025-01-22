package labs.intratech.services;

import labs.intratech.models.ImportanceExperience;
import org.springframework.stereotype.Service;
import labs.intratech.repositories.ImportanceExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class ImportanceExperienceService  {
	private final ImportanceExperienceRepository importanceExperienceRepository;

	@Autowired
	public ImportanceExperienceService(ImportanceExperienceRepository importanceExperienceRepository, ImportanceExperienceRepository importanceExperienceRepository1) {
        this.importanceExperienceRepository = importanceExperienceRepository1;
	}

	public List<ImportanceExperience> getAllImportanceExperience() {
	    return importanceExperienceRepository.findAll();
	}  

	public ImportanceExperience getImportanceExperienceById(Long id) {
	    Optional<ImportanceExperience> importanceExperience = importanceExperienceRepository.findById(id);
	    if (importanceExperience.isPresent()) {
	       return importanceExperience.get();
	    } else {
	       throw new RuntimeException("ImportanceExperience not found with id " + id);
	    }
	}

	public ImportanceExperience createImportanceExperience(ImportanceExperience importanceExperience) {
	    return importanceExperienceRepository.save(importanceExperience);
	}

	public ImportanceExperience updateImportanceExperience(Long id, ImportanceExperience importanceexperience) {
	    Optional<ImportanceExperience> existingImportanceExperience = importanceExperienceRepository.findById(id);
	       if (existingImportanceExperience.isPresent()) {
		       importanceexperience.setId(id);
	             return importanceExperienceRepository.save(importanceexperience);
	       } else {
	          throw new RuntimeException("ImportanceExperience not found with id " + id);
	       }
	}

	public void deleteImportanceExperience(Long id) {
		importanceExperienceRepository.deleteById(id);
	}

}



