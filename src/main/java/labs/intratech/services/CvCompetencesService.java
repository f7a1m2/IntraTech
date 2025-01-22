package labs.intratech.services;

import labs.intratech.models.CvCompetences;
import org.springframework.stereotype.Service;
import labs.intratech.repositories.CvCompetencesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class CvCompetencesService  {
	private final CvCompetencesRepository cvCompetencesRepository;

	@Autowired
	public CvCompetencesService(CvCompetencesRepository cvCompetencesRepository, CvCompetencesRepository cvCompetencesRepository1) {
        this.cvCompetencesRepository = cvCompetencesRepository1;
	}

	public List<CvCompetences> getAllCvCompetences() {
	    return cvCompetencesRepository.findAll();
	}  

	public CvCompetences getCvCompetencesById(Long id) {
	    Optional<CvCompetences> cvCompetences = cvCompetencesRepository.findById(id);
	    if (cvCompetences.isPresent()) {
	       return cvCompetences.get();
	    } else {
	       throw new RuntimeException("CvCompetences not found with id " + id);
	    }
	}

	public CvCompetences createCvCompetences(CvCompetences cvCompetences) {
	    return cvCompetencesRepository.save(cvCompetences);
	}

	public CvCompetences updateCvCompetences(Long id, CvCompetences cvcompetences) {
	    Optional<CvCompetences> existingCvCompetences = cvCompetencesRepository.findById(id);
	       if (existingCvCompetences.isPresent()) {
		       cvcompetences.setId(id);
	             return cvCompetencesRepository.save(cvcompetences);
	       } else {
	          throw new RuntimeException("CvCompetences not found with id " + id);
	       }
	}

	public void deleteCvCompetences(Long id) {
		cvCompetencesRepository.deleteById(id);
	}

}



