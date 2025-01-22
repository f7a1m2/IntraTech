package labs.intratech.models;

import jakarta.persistence.*;

@Entity
@Table(name="experiences")
public class Experiences  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="nom")
	private String nom;

	@Column(name="debut_intervalle")
	private Integer debutIntervalle;

	@Column(name="fin_intervalle")
	private Integer finIntervalle;
	

	public Experiences() {
	}

	public Experiences(String nom, Integer debutIntervalle, Integer finIntervalle) {
	    this.nom = nom;
	    this.debutIntervalle = debutIntervalle;
	    this.finIntervalle = finIntervalle;
	}

	public Experiences(Long id, String nom, Integer debutIntervalle, Integer finIntervalle) {
	    this.id = id;
	    this.nom = nom;
	    this.debutIntervalle = debutIntervalle;
	    this.finIntervalle = finIntervalle;
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
	
	public Integer getDebutIntervalle() {
	    return debutIntervalle;
	}

	public void setDebutIntervalle(Integer debutIntervalle) {
	    this.debutIntervalle = debutIntervalle;
	}
	
	public Integer getFinIntervalle() {
	    return finIntervalle;
	}

	public void setFinIntervalle(Integer finIntervalle) {
	    this.finIntervalle = finIntervalle;
	}

}



