package labs.intratech.models;

import jakarta.persistence.*;

@Entity
@Table(name="education")
public class Education  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="nom")
	private String nom;

	@Column(name="score_importance")
	private Integer scoreImportance;
	

	public Education() {
	}

	public Education(String nom, Integer scoreImportance) {
	    this.nom = nom;
	    this.scoreImportance = scoreImportance;
	}

	public Education(Long id, String nom, Integer scoreImportance) {
	    this.id = id;
	    this.nom = nom;
	    this.scoreImportance = scoreImportance;
	}

	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
	}
	
	public String getNom() {
	    return nom;
	}

	public void setNom(String nom) {
	    this.nom = nom;
	}
	
	public Integer getScoreImportance() {
	    return scoreImportance;
	}

	public void setScoreImportance(Integer scoreImportance) {
	    this.scoreImportance = scoreImportance;
	}

}



