package labs.intratech.models;

import jakarta.persistence.*;

@Entity
@Table(name="subscriptions")
public class Subscriptions  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@ManyToOne
	@JoinColumn(name="user_id")
	private Users users;

	@ManyToOne
	@JoinColumn(name="product_id")
	private SaasProducts saasProducts;

	@Column(name="start_date")
	private java.time.LocalDate startDate;

	@Column(name="end_date")
	private java.time.LocalDate endDate;

	@ManyToOne
	@JoinColumn(name="subscriptions_status_id")
	private SubscriptionsStatus subscriptionsStatus;
	

	public Subscriptions() {
	}

	public Subscriptions(Users users, SaasProducts saasProducts, java.time.LocalDate startDate, java.time.LocalDate endDate, SubscriptionsStatus subscriptionsStatus) {
	    this.users = users;
	    this.saasProducts = saasProducts;
	    this.startDate = startDate;
	    this.endDate = endDate;
	    this.subscriptionsStatus = subscriptionsStatus;
	}

	public Subscriptions(Long id, Users users, SaasProducts saasProducts, java.time.LocalDate startDate, java.time.LocalDate endDate, SubscriptionsStatus subscriptionsStatus) {
	    this.id = id;
	    this.users = users;
	    this.saasProducts = saasProducts;
	    this.startDate = startDate;
	    this.endDate = endDate;
	    this.subscriptionsStatus = subscriptionsStatus;
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
	
	public SaasProducts getSaasProducts() {
	    return saasProducts;
	}

	public void setSaasProducts(SaasProducts saasProducts) {
	    this.saasProducts = saasProducts;
	}
	
	public java.time.LocalDate getStartDate() {
	    return startDate;
	}

	public void setStartDate(java.time.LocalDate startDate) {
	    this.startDate = startDate;
	}
	
	public java.time.LocalDate getEndDate() {
	    return endDate;
	}

	public void setEndDate(java.time.LocalDate endDate) {
	    this.endDate = endDate;
	}
	
	public SubscriptionsStatus getSubscriptionsStatus() {
	    return subscriptionsStatus;
	}

	public void setSubscriptionsStatus(SubscriptionsStatus subscriptionsStatus) {
	    this.subscriptionsStatus = subscriptionsStatus;
	}

}



