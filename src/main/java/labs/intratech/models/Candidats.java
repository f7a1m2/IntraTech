package labs.intratech.models;

import jakarta.persistence.*;

@Entity
@Table(name="candidats")
public class Candidats  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@ManyToOne
	@JoinColumn(name="user_id")
	private Users users;

	@Column(name="cv_data")
	private String cvData;

	@Column(name="status")
	private String status;
	

	public Candidats() {
	}

	public Candidats(Users users, String cvData, String status) {
	    this.users = users;
	    this.cvData = cvData;
	    this.status = status;
	}

	public Candidats(Long id, Users users, String cvData, String status) {
	    this.id = id;
	    this.users = users;
	    this.cvData = cvData;
	    this.status = status;
	}

	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
	}
	
	public Users getUsers() {
	    return users;
	}

	public void setUsers(Users users) {
	    this.users = users;
	}
	
	public String getCvData() {
	    return cvData;
	}

	public void setCvData(String cvData) {
	    this.cvData = cvData;
	}
	
	public String getStatus() {
	    return status;
	}

	public void setStatus(String status) {
	    this.status = status;
	}

}



