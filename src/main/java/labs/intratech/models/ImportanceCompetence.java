package labs.intratech.models;

import jakarta.persistence.*;

@Entity
@Table(name="importance_competence")
public class ImportanceCompetence  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@ManyToOne
	@JoinColumn(name="id_poste")
	private Postes postes;

	@ManyToOne
	@JoinColumn(name="id_competence")
	private Competences competences;

	@Column(name="coefficient")
	private Double coefficient;
	

	public ImportanceCompetence() {
	}

	public ImportanceCompetence(Postes postes, Competences competences, Double coefficient) {
	    this.postes = postes;
	    this.competences = competences;
	    this.coefficient = coefficient;
	}

	public ImportanceCompetence(Long id, Postes postes, Competences competences, Double coefficient) {
	    this.id = id;
	    this.postes = postes;
	    this.competences = competences;
	    this.coefficient = coefficient;
	}

	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
	}
	
	public Postes getPostes() {
	    return postes;
	}

	public void setPostes(Postes postes) {
	    this.postes = postes;
	}
	
	public Competences getCompetences() {
	    return competences;
	}

	public void setCompetences(Competences competences) {
	    this.competences = competences;
	}
	
	public Double getCoefficient() {
	    return coefficient;
	}

	public void setCoefficient(Double coefficient) {
	    this.coefficient = coefficient;
	}

}



