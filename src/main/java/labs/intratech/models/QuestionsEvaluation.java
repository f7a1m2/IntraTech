package labs.intratech.models;

import jakarta.persistence.*;

@Entity
@Table(name="questions_evaluation")
public class QuestionsEvaluation  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="question")
	private String question;

	@Column(name="type")
	private String type;
	

	public QuestionsEvaluation() {
	}

	public QuestionsEvaluation(String question, String type) {
	    this.question = question;
	    this.type = type;
	}

	public QuestionsEvaluation(Long id, String question, String type) {
	    this.id = id;
	    this.question = question;
	    this.type = type;
	}

	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
	}
	
	public String getQuestion() {
	    return question;
	}

	public void setQuestion(String question) {
	    this.question = question;
	}
	
	public String getType() {
	    return type;
	}

	public void setType(String type) {
	    this.type = type;
	}

}



