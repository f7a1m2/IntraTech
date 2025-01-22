package labs.intratech.services;

import labs.intratech.models.Experiences;
import org.springframework.stereotype.Service;
import labs.intratech.repositories.ExperiencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class ExperiencesService  {
	private final ExperiencesRepository experiencesRepository;

	@Autowired
	public ExperiencesService(ExperiencesRepository experiencesRepository) {
	    this.experiencesRepository = experiencesRepository;
	}

	public List<Experiences> getAllExperiences() {
	    return experiencesRepository.findAll();
	}  

	public Experiences getExperiencesById(Long id) {
	    Optional<Experiences> experiences = experiencesRepository.findById(id);
	    if (experiences.isPresent()) {
	       return experiences.get();
	    } else {
	       throw new RuntimeException("Experiences not found with id " + id);
	    }
	}

	public Experiences createExperiences(Experiences experiences) {
	    return experiencesRepository.save(experiences);
	}

	public Experiences updateExperiences(Long id, Experiences experiences) {
	    Optional<Experiences> existingExperiences = experiencesRepository.findById(id);
	       if (existingExperiences.isPresent()) {
		       experiences.setId(id);
	             return experiencesRepository.save(experiences);
	       } else {
	          throw new RuntimeException("Experiences not found with id " + id);
	       }
	}

	public void deleteExperiences(Long id) {
	    experiencesRepository.deleteById(id);
	}

}



