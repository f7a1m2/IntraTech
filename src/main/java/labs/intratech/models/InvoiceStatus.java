package labs.intratech.models;

import jakarta.persistence.*;

@Entity
@Table(name="invoice_status")
public class InvoiceStatus  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="appelation")
	private String appelation;
	

	public InvoiceStatus() {
	}

	public InvoiceStatus(String appelation) {
	    this.appelation = appelation;
	}

	public InvoiceStatus(Long id, String appelation) {
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



