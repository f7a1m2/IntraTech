package labs.intratech.models;

import jakarta.persistence.*;

@Entity
@Table(name="candidatures")
public class Candidatures  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@ManyToOne
	@JoinColumn(name="id_candidat")
	private Candidats candidats;

	@ManyToOne
	@JoinColumn(name="id_offre")
	private Offres offres;

	@Column(name="date_candidature")
	private java.time.LocalDate dateCandidature;

	@Column(name="statut")
	private String statut;
	

	public Candidatures() {
	}

	public Candidatures(Candidats candidats, Offres offres, java.time.LocalDate dateCandidature, String statut) {
	    this.candidats = candidats;
	    this.offres = offres;
	    this.dateCandidature = dateCandidature;
	    this.statut = statut;
	}

	public Candidatures(Long id, Candidats candidats, Offres offres, java.time.LocalDate dateCandidature, String statut) {
	    this.id = id;
	    this.candidats = candidats;
	    this.offres = offres;
	    this.dateCandidature = dateCandidature;
	    this.statut = statut;
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
	
	public Offres getOffres() {
	    return offres;
	}

	public void setOffres(Offres offres) {
	    this.offres = offres;
	}
	
	public java.time.LocalDate getDateCandidature() {
	    return dateCandidature;
	}

	public void setDateCandidature(java.time.LocalDate dateCandidature) {
	    this.dateCandidature = dateCandidature;
	}
	
	public String getStatut() {
	    return statut;
	}

	public void setStatut(String statut) {
	    this.statut = statut;
	}

}



