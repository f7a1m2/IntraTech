package labs.intratech.models;

import jakarta.persistence.*;

@Entity
@Table(name="historique_performance_employe")
public class HistoriquePerformanceEmploye  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@ManyToOne
	@JoinColumn(name="id_employes")
	private Employes employes;

	@Column(name="score_competences")
	private Double scoreCompetences;

	@Column(name="score_education")
	private Double scoreEducation;

	@Column(name="score_experience")
	private Double scoreExperience;

	@Column(name="performance")
	private Double performance;

	@Column(name="date_mesure")
	private java.time.LocalDateTime dateMesure;
	

	public HistoriquePerformanceEmploye() {
	}

	public HistoriquePerformanceEmploye(Employes employes, Double scoreCompetences, Double scoreEducation, Double scoreExperience, Double performance, java.time.LocalDateTime dateMesure) {
	    this.employes = employes;
	    this.scoreCompetences = scoreCompetences;
	    this.scoreEducation = scoreEducation;
	    this.scoreExperience = scoreExperience;
	    this.performance = performance;
	    this.dateMesure = dateMesure;
	}

	public HistoriquePerformanceEmploye(Long id, Employes employes, Double scoreCompetences, Double scoreEducation, Double scoreExperience, Double performance, java.time.LocalDateTime dateMesure) {
	    this.id = id;
	    this.employes = employes;
	    this.scoreCompetences = scoreCompetences;
	    this.scoreEducation = scoreEducation;
	    this.scoreExperience = scoreExperience;
	    this.performance = performance;
	    this.dateMesure = dateMesure;
	}

	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
	}
	
	public Employes getEmployes() {
	    return employes;
	}

	public void setEmployes(Employes employes) {
	    this.employes = employes;
	}
	
	public Double getScoreCompetences() {
	    return scoreCompetences;
	}

	public void setScoreCompetences(Double scoreCompetences) {
	    this.scoreCompetences = scoreCompetences;
	}
	
	public Double getScoreEducation() {
	    return scoreEducation;
	}

	public void setScoreEducation(Double scoreEducation) {
	    this.scoreEducation = scoreEducation;
	}
	
	public Double getScoreExperience() {
	    return scoreExperience;
	}

	public void setScoreExperience(Double scoreExperience) {
	    this.scoreExperience = scoreExperience;
	}
	
	public Double getPerformance() {
	    return performance;
	}

	public void setPerformance(Double performance) {
	    this.performance = performance;
	}
	
	public java.time.LocalDateTime getDateMesure() {
	    return dateMesure;
	}

	public void setDateMesure(java.time.LocalDateTime dateMesure) {
	    this.dateMesure = dateMesure;
	}

}



