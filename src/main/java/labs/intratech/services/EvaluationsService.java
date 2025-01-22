package labs.intratech.services;

import labs.intratech.models.Evaluations;
import org.springframework.stereotype.Service;
import labs.intratech.repositories.EvaluationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class EvaluationsService  {
	private final EvaluationsRepository evaluationsRepository;

	@Autowired
	public EvaluationsService(EvaluationsRepository evaluationsRepository) {
	    this.evaluationsRepository = evaluationsRepository;
	}

	public List<Evaluations> getAllEvaluations() {
	    return evaluationsRepository.findAll();
	}  

	public Evaluations getEvaluationsById(Long id) {
	    Optional<Evaluations> evaluations = evaluationsRepository.findById(id);
	    if (evaluations.isPresent()) {
	       return evaluations.get();
	    } else {
	       throw new RuntimeException("Evaluations not found with id " + id);
	    }
	}

	public Evaluations createEvaluations(Evaluations evaluations) {
	    return evaluationsRepository.save(evaluations);
	}

	public Evaluations updateEvaluations(Long id, Evaluations evaluations) {
	    Optional<Evaluations> existingEvaluations = evaluationsRepository.findById(id);
	       if (existingEvaluations.isPresent()) {
		       evaluations.setEvaluationsid(id);
	             return evaluationsRepository.save(evaluations);
	       } else {
	          throw new RuntimeException("Evaluations not found with id " + id);
	       }
	}

	public void deleteEvaluations(Long id) {
	    evaluationsRepository.deleteById(id);
	}

}



