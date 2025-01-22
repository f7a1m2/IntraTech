package labs.intratech.models;

import jakarta.persistence.*;

@Entity
@Table(name="saas_products")
public class SaasProducts  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="product_name")
	private String productName;

	@Column(name="description")
	private String description;

	@Column(name="monthly_price")
	private Double monthlyPrice;

	@Column(name="annual_price")
	private Double annualPrice;
	

	public SaasProducts() {
	}

	public SaasProducts(String productName, String description, Double monthlyPrice, Double annualPrice) {
	    this.productName = productName;
	    this.description = description;
	    this.monthlyPrice = monthlyPrice;
	    this.annualPrice = annualPrice;
	}

	public SaasProducts(Long id, String productName, String description, Double monthlyPrice, Double annualPrice) {
	    this.id = id;
	    this.productName = productName;
	    this.description = description;
	    this.monthlyPrice = monthlyPrice;
	    this.annualPrice = annualPrice;
	}

	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
	}
	
	public String getProductName() {
	    return productName;
	}

	public void setProductName(String productName) {
	    this.productName = productName;
	}
	
	public String getDescription() {
	    return description;
	}

	public void setDescription(String description) {
	    this.description = description;
	}
	
	public Double getMonthlyPrice() {
	    return monthlyPrice;
	}

	public void setMonthlyPrice(Double monthlyPrice) {
	    this.monthlyPrice = monthlyPrice;
	}
	
	public Double getAnnualPrice() {
	    return annualPrice;
	}

	public void setAnnualPrice(Double annualPrice) {
	    this.annualPrice = annualPrice;
	}

}



