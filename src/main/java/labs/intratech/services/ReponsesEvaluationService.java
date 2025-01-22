package labs.intratech.services;

import labs.intratech.models.ReponsesEvaluation;
import org.springframework.stereotype.Service;
import labs.intratech.repositories.ReponsesEvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class ReponsesEvaluationService  {
	private final ReponsesEvaluationRepository reponsesEvaluationRepository;

	@Autowired
	public ReponsesEvaluationService(ReponsesEvaluationRepository reponsesEvaluationRepository) {
	    this.reponsesevaluationRepository = reponsesEvaluationRepository;
	}

	public List<ReponsesEvaluation> getAllReponsesEvaluation() {
	    return reponsesEvaluationRepository.findAll();
	}  

	public ReponsesEvaluation getReponsesEvaluationById(Long id) {
	    Optional<ReponsesEvaluation> reponsesEvaluation = reponsesEvaluationRepository.findById(id);
	    if (reponsesEvaluation.isPresent()) {
	       return reponsesEvaluation.get();
	    } else {
	       throw new RuntimeException("ReponsesEvaluation not found with id " + id);
	    }
	}

	public ReponsesEvaluation createReponsesEvaluation(ReponsesEvaluation reponsesEvaluation) {
	    return reponsesEvaluationRepository.save(reponsesEvaluation);
	}

	public ReponsesEvaluation updateReponsesEvaluation(Long id, ReponsesEvaluation reponsesevaluation) {
	    Optional<ReponsesEvaluation> existingReponsesEvaluation = reponsesevaluationRepository.findById(id);
	       if (existingReponsesEvaluation.isPresent()) {
		       reponsesevaluation.setReponsesEvaluationid(id);
	             return reponsesevaluationRepository.save(reponsesevaluation);
	       } else {
	          throw new RuntimeException("ReponsesEvaluation not found with id " + id);
	       }
	}

	public void deleteReponsesEvaluation(Long id) {
	    reponsesevaluationRepository.deleteById(id);
	}

}



