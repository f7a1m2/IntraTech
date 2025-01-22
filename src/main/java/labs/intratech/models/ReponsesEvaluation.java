package labs.intratech.models;

import jakarta.persistence.*;

@Entity
@Table(name="reponses_evaluation")
public class ReponsesEvaluation  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@ManyToOne
	@JoinColumn(name="id_evaluation")
	private Evaluations evaluations;

	@ManyToOne
	@JoinColumn(name="id_question")
	private QuestionsEvaluation questionsEvaluation;

	@Column(name="reponse_texte")
	private String reponseTexte;

	@Column(name="reponse_note")
	private Double reponseNote;

	@ManyToOne
	@JoinColumn(name="id_reponse_choisie")
	private ReponsesPossibles reponsesPossibles;

	@Column(name="commentaire")
	private String commentaire;
	

	public ReponsesEvaluation() {
	}

	public ReponsesEvaluation(Evaluations evaluations, QuestionsEvaluation questionsEvaluation, String reponseTexte, Double reponseNote, ReponsesPossibles reponsesPossibles, String commentaire) {
	    this.evaluations = evaluations;
	    this.questionsEvaluation = questionsEvaluation;
	    this.reponseTexte = reponseTexte;
	    this.reponseNote = reponseNote;
	    this.reponsesPossibles = reponsesPossibles;
	    this.commentaire = commentaire;
	}

	public ReponsesEvaluation(Long id, Evaluations evaluations, QuestionsEvaluation questionsEvaluation, String reponseTexte, Double reponseNote, ReponsesPossibles reponsesPossibles, String commentaire) {
	    this.id = id;
	    this.evaluations = evaluations;
	    this.questionsEvaluation = questionsEvaluation;
	    this.reponseTexte = reponseTexte;
	    this.reponseNote = reponseNote;
	    this.reponsesPossibles = reponsesPossibles;
	    this.commentaire = commentaire;
	}

	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
	}
	
	public Evaluations getEvaluations() {
	    return evaluations;
	}

	public void setEvaluations(Evaluations evaluations) {
	    this.evaluations = evaluations;
	}
	
	public QuestionsEvaluation getQuestionsEvaluation() {
	    return questionsEvaluation;
	}

	public void setQuestionsEvaluation(QuestionsEvaluation questionsEvaluation) {
	    this.questionsEvaluation = questionsEvaluation;
	}
	
	public String getReponseTexte() {
	    return reponseTexte;
	}

	public void setReponseTexte(String reponseTexte) {
	    this.reponseTexte = reponseTexte;
	}
	
	public Double getReponseNote() {
	    return reponseNote;
	}

	public void setReponseNote(Double reponseNote) {
	    this.reponseNote = reponseNote;
	}
	
	public ReponsesPossibles getReponsesPossibles() {
	    return reponsesPossibles;
	}

	public void setReponsesPossibles(ReponsesPossibles reponsesPossibles) {
	    this.reponsesPossibles = reponsesPossibles;
	}
	
	public String getCommentaire() {
	    return commentaire;
	}

	public void setCommentaire(String commentaire) {
	    this.commentaire = commentaire;
	}

}



