package labs.intratech.models;

import jakarta.persistence.*;

@Entity
@Table(name="cv_competences")
public class CvCompetences  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@ManyToOne
	@JoinColumn(name="id_cv")
	private Cv cv;

	@ManyToOne
	@JoinColumn(name="id_competence")
	private Competences competences;
	

	public CvCompetences() {
	}

	public CvCompetences(Cv cv, Competences competences) {
	    this.cv = cv;
	    this.competences = competences;
	}

	public CvCompetences(Long id, Cv cv, Competences competences) {
	    this.id = id;
	    this.cv = cv;
	    this.competences = competences;
	}

	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
	}
	
	public Cv getCv() {
	    return cv;
	}

	public void setCv(Cv cv) {
	    this.cv = cv;
	}
	
	public Competences getCompetences() {
	    return competences;
	}

	public void setCompetences(Competences competences) {
	    this.competences = competences;
	}

}



