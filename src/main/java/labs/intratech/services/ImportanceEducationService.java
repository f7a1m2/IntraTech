package labs.intratech.services;

import labs.intratech.models.ImportanceEducation;
import org.springframework.stereotype.Service;
import labs.intratech.repositories.ImportanceEducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class ImportanceEducationService  {
	private final ImportanceEducationRepository importanceEducationRepository;

	@Autowired
	public ImportanceEducationService(ImportanceEducationRepository importanceEducationRepository) {
	    this.importanceeducationRepository = importanceEducationRepository;
	}

	public List<ImportanceEducation> getAllImportanceEducation() {
	    return importanceEducationRepository.findAll();
	}  

	public ImportanceEducation getImportanceEducationById(Long id) {
	    Optional<ImportanceEducation> importanceEducation = importanceEducationRepository.findById(id);
	    if (importanceEducation.isPresent()) {
	       return importanceEducation.get();
	    } else {
	       throw new RuntimeException("ImportanceEducation not found with id " + id);
	    }
	}

	public ImportanceEducation createImportanceEducation(ImportanceEducation importanceEducation) {
	    return importanceEducationRepository.save(importanceEducation);
	}

	public ImportanceEducation updateImportanceEducation(Long id, ImportanceEducation importanceeducation) {
	    Optional<ImportanceEducation> existingImportanceEducation = importanceeducationRepository.findById(id);
	       if (existingImportanceEducation.isPresent()) {
		       importanceeducation.setImportanceEducationid(id);
	             return importanceeducationRepository.save(importanceeducation);
	       } else {
	          throw new RuntimeException("ImportanceEducation not found with id " + id);
	       }
	}

	public void deleteImportanceEducation(Long id) {
	    importanceeducationRepository.deleteById(id);
	}

}



