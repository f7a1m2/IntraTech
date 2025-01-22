package labs.intratech.services;

import labs.intratech.models.QuestionsEvaluation;
import org.springframework.stereotype.Service;
import labs.intratech.repositories.QuestionsEvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionsEvaluationService  {
	private final QuestionsEvaluationRepository questionsEvaluationRepository;

	@Autowired
	public QuestionsEvaluationService(QuestionsEvaluationRepository questionsEvaluationRepository) {
	    this.questionsevaluationRepository = questionsEvaluationRepository;
	}

	public List<QuestionsEvaluation> getAllQuestionsEvaluation() {
	    return questionsEvaluationRepository.findAll();
	}  

	public QuestionsEvaluation getQuestionsEvaluationById(Long id) {
	    Optional<QuestionsEvaluation> questionsEvaluation = questionsEvaluationRepository.findById(id);
	    if (questionsEvaluation.isPresent()) {
	       return questionsEvaluation.get();
	    } else {
	       throw new RuntimeException("QuestionsEvaluation not found with id " + id);
	    }
	}

	public QuestionsEvaluation createQuestionsEvaluation(QuestionsEvaluation questionsEvaluation) {
	    return questionsEvaluationRepository.save(questionsEvaluation);
	}

	public QuestionsEvaluation updateQuestionsEvaluation(Long id, QuestionsEvaluation questionsevaluation) {
	    Optional<QuestionsEvaluation> existingQuestionsEvaluation = questionsevaluationRepository.findById(id);
	       if (existingQuestionsEvaluation.isPresent()) {
		       questionsevaluation.setQuestionsEvaluationid(id);
	             return questionsevaluationRepository.save(questionsevaluation);
	       } else {
	          throw new RuntimeException("QuestionsEvaluation not found with id " + id);
	       }
	}

	public void deleteQuestionsEvaluation(Long id) {
	    questionsevaluationRepository.deleteById(id);
	}

}



