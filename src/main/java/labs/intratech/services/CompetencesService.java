package labs.intratech.services;

import labs.intratech.models.Competences;
import org.springframework.stereotype.Service;
import labs.intratech.repositories.CompetencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class CompetencesService  {
	private final CompetencesRepository competencesRepository;

	@Autowired
	public CompetencesService(CompetencesRepository competencesRepository) {
	    this.competencesRepository = competencesRepository;
	}

	public List<Competences> getAllCompetences() {
	    return competencesRepository.findAll();
	}  

	public Competences getCompetencesById(Long id) {
	    Optional<Competences> competences = competencesRepository.findById(id);
	    if (competences.isPresent()) {
	       return competences.get();
	    } else {
	       throw new RuntimeException("Competences not found with id " + id);
	    }
	}

	public Competences createCompetences(Competences competences) {
	    return competencesRepository.save(competences);
	}

	public Competences updateCompetences(Long id, Competences competences) {
	    Optional<Competences> existingCompetences = competencesRepository.findById(id);
	       if (existingCompetences.isPresent()) {
		       competences.setCompetencesid(id);
	             return competencesRepository.save(competences);
	       } else {
	          throw new RuntimeException("Competences not found with id " + id);
	       }
	}

	public void deleteCompetences(Long id) {
	    competencesRepository.deleteById(id);
	}

}



