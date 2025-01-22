package labs.intratech.models;

import jakarta.persistence.*;

@Entity
@Table(name="invoices")
public class Invoices  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@ManyToOne
	@JoinColumn(name="subscription_id")
	private Subscriptions subscriptions;

	@Column(name="total_amount")
	private Double totalAmount;

	@Column(name="created_at")
	private java.time.LocalDateTime createdAt;

	@ManyToOne
	@JoinColumn(name="invoice_status_id")
	private InvoiceStatus invoiceStatus;
	

	public Invoices() {
	}

	public Invoices(Subscriptions subscriptions, Double totalAmount, java.time.LocalDateTime createdAt, InvoiceStatus invoiceStatus) {
	    this.subscriptions = subscriptions;
	    this.totalAmount = totalAmount;
	    this.createdAt = createdAt;
	    this.invoiceStatus = invoiceStatus;
	}

	public Invoices(Long id, Subscriptions subscriptions, Double totalAmount, java.time.LocalDateTime createdAt, InvoiceStatus invoiceStatus) {
	    this.id = id;
	    this.subscriptions = subscriptions;
	    this.totalAmount = totalAmount;
	    this.createdAt = createdAt;
	    this.invoiceStatus = invoiceStatus;
	}

	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
	}
	
	public Subscriptions getSubscriptions() {
	    return subscriptions;
	}

	public void setSubscriptions(Subscriptions subscriptions) {
	    this.subscriptions = subscriptions;
	}
	
	public Double getTotalAmount() {
	    return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
	    this.totalAmount = totalAmount;
	}
	
	public java.time.LocalDateTime getCreatedAt() {
	    return createdAt;
	}

	public void setCreatedAt(java.time.LocalDateTime createdAt) {
	    this.createdAt = createdAt;
	}
	
	public InvoiceStatus getInvoiceStatus() {
	    return invoiceStatus;
	}

	public void setInvoiceStatus(InvoiceStatus invoiceStatus) {
	    this.invoiceStatus = invoiceStatus;
	}

}



