package labs.intratech.models;

import jakarta.persistence.*;

@Entity
@Table(name="importance_education")
public class ImportanceEducation  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@ManyToOne
	@JoinColumn(name="id_poste")
	private Postes postes;

	@ManyToOne
	@JoinColumn(name="id_education")
	private Education education;

	@Column(name="coefficient")
	private Double coefficient;
	

	public ImportanceEducation() {
	}

	public ImportanceEducation(Postes postes, Education education, Double coefficient) {
	    this.postes = postes;
	    this.education = education;
	    this.coefficient = coefficient;
	}

	public ImportanceEducation(Long id, Postes postes, Education education, Double coefficient) {
	    this.id = id;
	    this.postes = postes;
	    this.education = education;
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
	
	public Education getEducation() {
	    return education;
	}

	public void setEducation(Education education) {
	    this.education = education;
	}
	
	public Double getCoefficient() {
	    return coefficient;
	}

	public void setCoefficient(Double coefficient) {
	    this.coefficient = coefficient;
	}

}



