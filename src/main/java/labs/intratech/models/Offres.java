package labs.intratech.models;

import jakarta.persistence.*;

@Entity
@Table(name="offres")
public class Offres  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@ManyToOne
	@JoinColumn(name="id_poste")
	private Postes postes;

	@Column(name="titre")
	private String titre;

	@Column(name="description")
	private String description;

	@Column(name="date_publication")
	private java.time.LocalDate datePublication;

	@Column(name="date_expiration")
	private java.time.LocalDate dateExpiration;

	@Column(name="nombre_positions")
	private Integer nombrePositions;
	

	public Offres() {
	}

	public Offres(Postes postes, String titre, String description, java.time.LocalDate datePublication, java.time.LocalDate dateExpiration, Integer nombrePositions) {
	    this.postes = postes;
	    this.titre = titre;
	    this.description = description;
	    this.datePublication = datePublication;
	    this.dateExpiration = dateExpiration;
	    this.nombrePositions = nombrePositions;
	}

	public Offres(Long id, Postes postes, String titre, String description, java.time.LocalDate datePublication, java.time.LocalDate dateExpiration, Integer nombrePositions) {
	    this.id = id;
	    this.postes = postes;
	    this.titre = titre;
	    this.description = description;
	    this.datePublication = datePublication;
	    this.dateExpiration = dateExpiration;
	    this.nombrePositions = nombrePositions;
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
	
	public String getTitre() {
	    return titre;
	}

	public void setTitre(String titre) {
	    this.titre = titre;
	}
	
	public String getDescription() {
	    return description;
	}

	public void setDescription(String description) {
	    this.description = description;
	}
	
	public java.time.LocalDate getDatePublication() {
	    return datePublication;
	}

	public void setDatePublication(java.time.LocalDate datePublication) {
	    this.datePublication = datePublication;
	}
	
	public java.time.LocalDate getDateExpiration() {
	    return dateExpiration;
	}

	public void setDateExpiration(java.time.LocalDate dateExpiration) {
	    this.dateExpiration = dateExpiration;
	}
	
	public Integer getNombrePositions() {
	    return nombrePositions;
	}

	public void setNombrePositions(Integer nombrePositions) {
	    this.nombrePositions = nombrePositions;
	}

}



