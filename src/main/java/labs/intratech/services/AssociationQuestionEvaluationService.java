package labs.intratech.services;

import labs.intratech.models.AssociationQuestionEvaluation;
import org.springframework.stereotype.Service;
import labs.intratech.repositories.AssociationQuestionEvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class AssociationQuestionEvaluationService  {
	private final AssociationQuestionEvaluationRepository associationQuestionEvaluationRepository;

	@Autowired
	public AssociationQuestionEvaluationService(AssociationQuestionEvaluationRepository associationQuestionEvaluationRepository) {
	    this.associationquestionevaluationRepository = associationQuestionEvaluationRepository;
	}

	public List<AssociationQuestionEvaluation> getAllAssociationQuestionEvaluation() {
	    return associationQuestionEvaluationRepository.findAll();
	}  

	public AssociationQuestionEvaluation getAssociationQuestionEvaluationById(Long id) {
	    Optional<AssociationQuestionEvaluation> associationQuestionEvaluation = associationQuestionEvaluationRepository.findById(id);
	    if (associationQuestionEvaluation.isPresent()) {
	       return associationQuestionEvaluation.get();
	    } else {
	       throw new RuntimeException("AssociationQuestionEvaluation not found with id " + id);
	    }
	}

	public AssociationQuestionEvaluation createAssociationQuestionEvaluation(AssociationQuestionEvaluation associationQuestionEvaluation) {
	    return associationQuestionEvaluationRepository.save(associationQuestionEvaluation);
	}

	public AssociationQuestionEvaluation updateAssociationQuestionEvaluation(Long id, AssociationQuestionEvaluation associationquestionevaluation) {
	    Optional<AssociationQuestionEvaluation> existingAssociationQuestionEvaluation = associationquestionevaluationRepository.findById(id);
	       if (existingAssociationQuestionEvaluation.isPresent()) {
		       associationquestionevaluation.setAssociationQuestionEvaluationid(id);
	             return associationquestionevaluationRepository.save(associationquestionevaluation);
	       } else {
	          throw new RuntimeException("AssociationQuestionEvaluation not found with id " + id);
	       }
	}

	public void deleteAssociationQuestionEvaluation(Long id) {
	    associationquestionevaluationRepository.deleteById(id);
	}

}



