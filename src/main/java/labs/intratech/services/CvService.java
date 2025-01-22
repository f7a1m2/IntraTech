package labs.intratech.services;

import labs.intratech.models.Cv;
import org.springframework.stereotype.Service;
import labs.intratech.repositories.CvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class CvService  {
	private final CvRepository cvRepository;

	@Autowired
	public CvService(CvRepository cvRepository) {
	    this.cvRepository = cvRepository;
	}

	public List<Cv> getAllCv() {
	    return cvRepository.findAll();
	}  

	public Cv getCvById(Long id) {
	    Optional<Cv> cv = cvRepository.findById(id);
	    if (cv.isPresent()) {
	       return cv.get();
	    } else {
	       throw new RuntimeException("Cv not found with id " + id);
	    }
	}

	public Cv createCv(Cv cv) {
	    return cvRepository.save(cv);
	}

	public Cv updateCv(Long id, Cv cv) {
	    Optional<Cv> existingCv = cvRepository.findById(id);
	       if (existingCv.isPresent()) {
		       cv.setId(id);
	             return cvRepository.save(cv);
	       } else {
	          throw new RuntimeException("Cv not found with id " + id);
	       }
	}

	public void deleteCv(Long id) {
	    cvRepository.deleteById(id);
	}

}



