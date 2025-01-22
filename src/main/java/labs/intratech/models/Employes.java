package labs.intratech.models;

import jakarta.persistence.*;

@Entity
@Table(name="employes")
public class Employes  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@ManyToOne
	@JoinColumn(name="id_candidat")
	private Candidats candidats;

	@Column(name="date_embauche")
	private java.time.LocalDate dateEmbauche;

	@ManyToOne
	@JoinColumn(name="id_poste")
	private Postes postes;

	@Column(name="contrat_type")
	private String contratType;

	@Column(name="salaire")
	private Double salaire;

	@ManyToOne
	@JoinColumn(name="user_id")
	private Users users;
	

	public Employes() {
	}

	public Employes(Candidats candidats, java.time.LocalDate dateEmbauche, Postes postes, String contratType, Double salaire, Users users) {
	    this.candidats = candidats;
	    this.dateEmbauche = dateEmbauche;
	    this.postes = postes;
	    this.contratType = contratType;
	    this.salaire = salaire;
	    this.users = users;
	}

	public Employes(Long id, Candidats candidats, java.time.LocalDate dateEmbauche, Postes postes, String contratType, Double salaire, Users users) {
	    this.id = id;
	    this.candidats = candidats;
	    this.dateEmbauche = dateEmbauche;
	    this.postes = postes;
	    this.contratType = contratType;
	    this.salaire = salaire;
	    this.users = users;
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
	
	public java.time.LocalDate getDateEmbauche() {
	    return dateEmbauche;
	}

	public void setDateEmbauche(java.time.LocalDate dateEmbauche) {
	    this.dateEmbauche = dateEmbauche;
	}
	
	public Postes getPostes() {
	    return postes;
	}

	public void setPostes(Postes postes) {
	    this.postes = postes;
	}
	
	public String getContratType() {
	    return contratType;
	}

	public void setContratType(String contratType) {
	    this.contratType = contratType;
	}
	
	public Double getSalaire() {
	    return salaire;
	}

	public void setSalaire(Double salaire) {
	    this.salaire = salaire;
	}
	
	public Users getUsers() {
	    return users;
	}

	public void setUsers(Users users) {
	    this.users = users;
	}

}



