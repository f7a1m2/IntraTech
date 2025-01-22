package labs.intratech.models;

import jakarta.persistence.*;

@Entity
@Table(name="product_stocks")
public class ProductStocks  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="stock_id")
	private Long stockId;

	@ManyToOne
	@JoinColumn(name="product_id")
	private SaasProducts saasProducts;

	@Column(name="annee")
	private Double annee;

	@Column(name="stock_quantity")
	private Double stockQuantity;
	

	public ProductStocks() {
	}

	public ProductStocks(SaasProducts saasProducts, Double annee, Double stockQuantity) {
	    this.saasProducts = saasProducts;
	    this.annee = annee;
	    this.stockQuantity = stockQuantity;
	}

	public ProductStocks(Long stockId, SaasProducts saasProducts, Double annee, Double stockQuantity) {
	    this.stockId = stockId;
	    this.saasProducts = saasProducts;
	    this.annee = annee;
	    this.stockQuantity = stockQuantity;
	}

	public Long getStockId() {
	    return stockId;
	}

	public void setStockId(Long stockId) {
	    this.stockId = stockId;
	}
	
	public SaasProducts getSaasProducts() {
	    return saasProducts;
	}

	public void setSaasProducts(SaasProducts saasProducts) {
	    this.saasProducts = saasProducts;
	}
	
	public Double getAnnee() {
	    return annee;
	}

	public void setAnnee(Double annee) {
	    this.annee = annee;
	}
	
	public Double getStockQuantity() {
	    return stockQuantity;
	}

	public void setStockQuantity(Double stockQuantity) {
	    this.stockQuantity = stockQuantity;
	}

}



