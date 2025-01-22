package labs.intratech.models;

import jakarta.persistence.*;

@Entity
@Table(name="importance_experience")
public class ImportanceExperience  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@ManyToOne
	@JoinColumn(name="id_poste")
	private Postes postes;

	@ManyToOne
	@JoinColumn(name="id_experience")
	private Experiences experiences;

	@Column(name="coefficient")
	private Double coefficient;
	

	public ImportanceExperience() {
	}

	public ImportanceExperience(Postes postes, Experiences experiences, Double coefficient) {
	    this.postes = postes;
	    this.experiences = experiences;
	    this.coefficient = coefficient;
	}

	public ImportanceExperience(Long id, Postes postes, Experiences experiences, Double coefficient) {
	    this.id = id;
	    this.postes = postes;
	    this.experiences = experiences;
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
	
	public Experiences getExperiences() {
	    return experiences;
	}

	public void setExperiences(Experiences experiences) {
	    this.experiences = experiences;
	}
	
	public Double getCoefficient() {
	    return coefficient;
	}

	public void setCoefficient(Double coefficient) {
	    this.coefficient = coefficient;
	}

}



