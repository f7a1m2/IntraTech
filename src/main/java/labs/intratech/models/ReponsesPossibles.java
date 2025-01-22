package labs.intratech.models;

import jakarta.persistence.*;

@Entity
@Table(name="reponses_possibles")
public class ReponsesPossibles  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@ManyToOne
	@JoinColumn(name="id_question")
	private QuestionsEvaluation questionsEvaluation;

	@Column(name="reponse")
	private String reponse;

	@Column(name="est_correcte")
	private java.lang.Boolean estCorrecte;
	

	public ReponsesPossibles() {
	}

	public ReponsesPossibles(QuestionsEvaluation questionsEvaluation, String reponse, java.lang.Boolean estCorrecte) {
	    this.questionsEvaluation = questionsEvaluation;
	    this.reponse = reponse;
	    this.estCorrecte = estCorrecte;
	}

	public ReponsesPossibles(Long id, QuestionsEvaluation questionsEvaluation, String reponse, java.lang.Boolean estCorrecte) {
	    this.id = id;
	    this.questionsEvaluation = questionsEvaluation;
	    this.reponse = reponse;
	    this.estCorrecte = estCorrecte;
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
	
	public String getReponse() {
	    return reponse;
	}

	public void setReponse(String reponse) {
	    this.reponse = reponse;
	}
	
	public java.lang.Boolean getEstCorrecte() {
	    return estCorrecte;
	}

	public void setEstCorrecte(java.lang.Boolean estCorrecte) {
	    this.estCorrecte = estCorrecte;
	}

}



