package labs.intratech.services;

import labs.intratech.models.Education;
import org.springframework.stereotype.Service;
import labs.intratech.repositories.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class EducationService  {
	private final EducationRepository educationRepository;

	@Autowired
	public EducationService(EducationRepository educationRepository) {
	    this.educationRepository = educationRepository;
	}

	public List<Education> getAllEducation() {
	    return educationRepository.findAll();
	}  

	public Education getEducationById(Long id) {
	    Optional<Education> education = educationRepository.findById(id);
	    if (education.isPresent()) {
	       return education.get();
	    } else {
	       throw new RuntimeException("Education not found with id " + id);
	    }
	}

	public Education createEducation(Education education) {
	    return educationRepository.save(education);
	}

	public Education updateEducation(Long id, Education education) {
	    Optional<Education> existingEducation = educationRepository.findById(id);
	       if (existingEducation.isPresent()) {
		       education.setEducationid(id);
	             return educationRepository.save(education);
	       } else {
	          throw new RuntimeException("Education not found with id " + id);
	       }
	}

	public void deleteEducation(Long id) {
	    educationRepository.deleteById(id);
	}

}



