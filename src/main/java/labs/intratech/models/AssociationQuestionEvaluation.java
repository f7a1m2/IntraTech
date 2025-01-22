package labs.intratech.models;

import jakarta.persistence.*;

@Entity
@Table(name="association_question_evaluation")
public class AssociationQuestionEvaluation  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@ManyToOne
	@JoinColumn(name="id_question")
	private QuestionsEvaluation questionsEvaluation;

	@ManyToOne
	@JoinColumn(name="id_evaluation")
	private Evaluations evaluations;
	

	public AssociationQuestionEvaluation() {
	}

	public AssociationQuestionEvaluation(QuestionsEvaluation questionsEvaluation, Evaluations evaluations) {
	    this.questionsEvaluation = questionsEvaluation;
	    this.evaluations = evaluations;
	}

	public AssociationQuestionEvaluation(Long id, QuestionsEvaluation questionsEvaluation, Evaluations evaluations) {
	    this.id = id;
	    this.questionsEvaluation = questionsEvaluation;
	    this.evaluations = evaluations;
	}

	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
	}
	
	public QuestionsEvaluation getQuestionsEvaluation() {
	    return questionsEvaluation;
	}

	public void setQuestionsEvaluation(QuestionsEvaluation questionsEvaluation) {
	    this.questionsEvaluation = questionsEvaluation;
	}
	
	public Evaluations getEvaluations() {
	    return evaluations;
	}

	public void setEvaluations(Evaluations evaluations) {
	    this.evaluations = evaluations;
	}

}



