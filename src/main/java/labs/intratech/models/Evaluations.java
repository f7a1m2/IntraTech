package labs.intratech.models;

import jakarta.persistence.*;

@Entity
@Table(name="evaluations")
public class Evaluations  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@ManyToOne
	@JoinColumn(name="id_candidature")
	private Candidatures candidatures;

	@Column(name="type")
	private String type;

	@Column(name="date")
	private java.time.LocalDate date;

	@Column(name="commentaire_general")
	private String commentaireGeneral;
	

	public Evaluations() {
	}

	public Evaluations(Candidatures candidatures, String type, java.time.LocalDate date, String commentaireGeneral) {
	    this.candidatures = candidatures;
	    this.type = type;
	    this.date = date;
	    this.commentaireGeneral = commentaireGeneral;
	}

	public Evaluations(Long id, Candidatures candidatures, String type, java.time.LocalDate date, String commentaireGeneral) {
	    this.id = id;
	    this.candidatures = candidatures;
	    this.type = type;
	    this.date = date;
	    this.commentaireGeneral = commentaireGeneral;
	}

	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
	}
	
	public Candidatures getCandidatures() {
	    return candidatures;
	}

	public void setCandidatures(Candidatures candidatures) {
	    this.candidatures = candidatures;
	}
	
	public String getType() {
	    return type;
	}

	public void setType(String type) {
	    this.type = type;
	}
	
	public java.time.LocalDate getDate() {
	    return date;
	}

	public void setDate(java.time.LocalDate date) {
	    this.date = date;
	}
	
	public String getCommentaireGeneral() {
	    return commentaireGeneral;
	}

	public void setCommentaireGeneral(String commentaireGeneral) {
	    this.commentaireGeneral = commentaireGeneral;
	}

}



