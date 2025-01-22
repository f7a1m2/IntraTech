package labs.intratech.models;

import jakarta.persistence.*;

@Entity
@Table(name="postes")
public class Postes  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="intitule")
	private String intitule;

	@Column(name="id_categorie")
	private String idCategorie;

	@Column(name="description")
	private String description;
	

	public Postes() {
	}

	public Postes(String intitule, String idCategorie, String description) {
	    this.intitule = intitule;
	    this.idCategorie = idCategorie;
	    this.description = description;
	}

	public Postes(Long id, String intitule, String idCategorie, String description) {
	    this.id = id;
	    this.intitule = intitule;
	    this.idCategorie = idCategorie;
	    this.description = description;
	}

	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
	}
	
	public String getIntitule() {
	    return intitule;
	}

	public void setIntitule(String intitule) {
	    this.intitule = intitule;
	}
	
	public String getIdCategorie() {
	    return idCategorie;
	}

	public void setIdCategorie(String idCategorie) {
	    this.idCategorie = idCategorie;
	}
	
	public String getDescription() {
	    return description;
	}

	public void setDescription(String description) {
	    this.description = description;
	}

}



