package labs.intratech.models;

import jakarta.persistence.*;

@Entity
@Table(name="competences")
public class Competences  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="nom")
	private String nom;
	

	public Competences() {
	}

	public Competences(String nom) {
	    this.nom = nom;
	}

	public Competences(Long id, String nom) {
	    this.id = id;
	    this.nom = nom;
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

}



