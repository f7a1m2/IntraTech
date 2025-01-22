package labs.intratech.models;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class Users  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="user_name")
	private String userName;

	@Column(name="email")
	private String email;

	@Column(name="pass")
	private String pass;

	@Column(name="user_role")
	private String userRole;
	

	public Users() {
	}

	public Users(String userName, String email, String pass, String userRole) {
	    this.userName = userName;
	    this.email = email;
	    this.pass = pass;
	    this.userRole = userRole;
	}

	public Users(Long id, String userName, String email, String pass, String userRole) {
	    this.id = id;
	    this.userName = userName;
	    this.email = email;
	    this.pass = pass;
	    this.userRole = userRole;
	}

	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
	}
	
	public String getUserName() {
	    return userName;
	}

	public void setUserName(String userName) {
	    this.userName = userName;
	}
	
	public String getEmail() {
	    return email;
	}

	public void setEmail(String email) {
	    this.email = email;
	}
	
	public String getPass() {
	    return pass;
	}

	public void setPass(String pass) {
	    this.pass = pass;
	}
	
	public String getUserRole() {
	    return userRole;
	}

	public void setUserRole(String userRole) {
	    this.userRole = userRole;
	}

}



