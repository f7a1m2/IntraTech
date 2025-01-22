package labs.intratech.models;

import jakarta.persistence.*;

@Entity
@Table(name="subscriptions_status")
public class SubscriptionsStatus  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="appelation")
	private String appelation;
	

	public SubscriptionsStatus() {
	}

	public SubscriptionsStatus(String appelation) {
	    this.appelation = appelation;
	}

	public SubscriptionsStatus(Long id, String appelation) {
	    this.id = id;
	    this.appelation = appelation;
	}

	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
	}
	
	public String getAppelation() {
	    return appelation;
	}

	public void setAppelation(String appelation) {
	    this.appelation = appelation;
	}

}



