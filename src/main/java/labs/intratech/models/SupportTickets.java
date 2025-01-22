package labs.intratech.models;

import jakarta.persistence.*;

@Entity
@Table(name="support_tickets")
public class SupportTickets  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@ManyToOne
	@JoinColumn(name="user_id")
	private Users users;

	@Column(name="sujet")
	private String sujet;

	@Column(name="description")
	private String description;

	@ManyToOne
	@JoinColumn(name="support_tickets_status_id")
	private SupportTicketsStatus supportTicketsStatus;

	@Column(name="created_at")
	private java.time.LocalDateTime createdAt;
	

	public SupportTickets() {
	}

	public SupportTickets(Users users, String sujet, String description, SupportTicketsStatus supportTicketsStatus, java.time.LocalDateTime createdAt) {
	    this.users = users;
	    this.sujet = sujet;
	    this.description = description;
	    this.supportTicketsStatus = supportTicketsStatus;
	    this.createdAt = createdAt;
	}

	public SupportTickets(Long id, Users users, String sujet, String description, SupportTicketsStatus supportTicketsStatus, java.time.LocalDateTime createdAt) {
	    this.id = id;
	    this.users = users;
	    this.sujet = sujet;
	    this.description = description;
	    this.supportTicketsStatus = supportTicketsStatus;
	    this.createdAt = createdAt;
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
	
	public String getSujet() {
	    return sujet;
	}

	public void setSujet(String sujet) {
	    this.sujet = sujet;
	}
	
	public String getDescription() {
	    return description;
	}

	public void setDescription(String description) {
	    this.description = description;
	}
	
	public SupportTicketsStatus getSupportTicketsStatus() {
	    return supportTicketsStatus;
	}

	public void setSupportTicketsStatus(SupportTicketsStatus supportTicketsStatus) {
	    this.supportTicketsStatus = supportTicketsStatus;
	}
	
	public java.time.LocalDateTime getCreatedAt() {
	    return createdAt;
	}

	public void setCreatedAt(java.time.LocalDateTime createdAt) {
	    this.createdAt = createdAt;
	}

}



