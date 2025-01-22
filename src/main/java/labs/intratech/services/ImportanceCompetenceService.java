package labs.intratech.services;

import labs.intratech.models.ImportanceCompetence;
import org.springframework.stereotype.Service;
import labs.intratech.repositories.ImportanceCompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class ImportanceCompetenceService  {
	private final ImportanceCompetenceRepository importanceCompetenceRepository;

	@Autowired
	public ImportanceCompetenceService(ImportanceCompetenceRepository importanceCompetenceRepository, ImportanceCompetenceRepository importanceCompetenceRepository1) {
        this.importanceCompetenceRepository = importanceCompetenceRepository1;
	}

	public List<ImportanceCompetence> getAllImportanceCompetence() {
	    return importanceCompetenceRepository.findAll();
	}  

	public ImportanceCompetence getImportanceCompetenceById(Long id) {
	    Optional<ImportanceCompetence> importanceCompetence = importanceCompetenceRepository.findById(id);
	    if (importanceCompetence.isPresent()) {
	       return importanceCompetence.get();
	    } else {
	       throw new RuntimeException("ImportanceCompetence not found with id " + id);
	    }
	}

	public ImportanceCompetence createImportanceCompetence(ImportanceCompetence importanceCompetence) {
	    return importanceCompetenceRepository.save(importanceCompetence);
	}

	public ImportanceCompetence updateImportanceCompetence(Long id, ImportanceCompetence importancecompetence) {
	    Optional<ImportanceCompetence> existingImportanceCompetence = importanceCompetenceRepository.findById(id);
	       if (existingImportanceCompetence.isPresent()) {
		       importancecompetence.setId(id);
	             return importanceCompetenceRepository.save(importancecompetence);
	       } else {
	          throw new RuntimeException("ImportanceCompetence not found with id " + id);
	       }
	}

	public void deleteImportanceCompetence(Long id) {
		importanceCompetenceRepository.deleteById(id);
	}

}



