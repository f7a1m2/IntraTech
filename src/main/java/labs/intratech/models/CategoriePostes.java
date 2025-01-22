package labs.intratech.models;

import jakarta.persistence.*;

@Entity
@Table(name="categorie_postes")
public class CategoriePostes  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="nom")
	private String nom;
	

	public CategoriePostes() {
	}

	public CategoriePostes(String nom) {
	    this.nom = nom;
	}

	public CategoriePostes(Long id, String nom) {
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



