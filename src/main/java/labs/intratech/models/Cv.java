package labs.intratech.models;

import jakarta.persistence.*;

@Entity
@Table(name="cv")
public class Cv  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@ManyToOne
	@JoinColumn(name="id_candidat")
	private Candidats candidats;

	@Column(name="contenu")
	private String contenu;

	@Column(name="experience")
	private Double experience;

	@Column(name="education")
	private String education;

	@Column(name="coeff_filtrage")
	private Double coeffFiltrage;
	

	public Cv() {
	}

	public Cv(Candidats candidats, String contenu, Double experience, String education, Double coeffFiltrage) {
	    this.candidats = candidats;
	    this.contenu = contenu;
	    this.experience = experience;
	    this.education = education;
	    this.coeffFiltrage = coeffFiltrage;
	}

	public Cv(Long id, Candidats candidats, String contenu, Double experience, String education, Double coeffFiltrage) {
	    this.id = id;
	    this.candidats = candidats;
	    this.contenu = contenu;
	    this.experience = experience;
	    this.education = education;
	    this.coeffFiltrage = coeffFiltrage;
	}

	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
	}
	
	public Candidats getCandidats() {
	    return candidats;
	}

	public void setCandidats(Candidats candidats) {
	    this.candidats = candidats;
	}
	
	public String getContenu() {
	    return contenu;
	}

	public void setContenu(String contenu) {
	    this.contenu = contenu;
	}
	
	public Double getExperience() {
	    return experience;
	}

	public void setExperience(Double experience) {
	    this.experience = experience;
	}
	
	public String getEducation() {
	    return education;
	}

	public void setEducation(String education) {
	    this.education = education;
	}
	
	public Double getCoeffFiltrage() {
	    return coeffFiltrage;
	}

	public void setCoeffFiltrage(Double coeffFiltrage) {
	    this.coeffFiltrage = coeffFiltrage;
	}

}



