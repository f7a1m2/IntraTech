package labs.intratech.models;

import jakarta.persistence.*;

@Entity
@Table(name="financial_indicators")
public class FinancialIndicators  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="indicator_id")
	private Long indicatorId;

	@Column(name="annee")
	private Double annee;

	@Column(name="total_assets")
	private Double totalAssets;

	@Column(name="current_assets")
	private Double currentAssets;

	@Column(name="fixed_assets")
	private Double fixedAssets;

	@Column(name="total_liabilities")
	private Double totalLiabilities;

	@Column(name="current_liabilities")
	private Double currentLiabilities;

	@Column(name="non_current_liabilities")
	private Double nonCurrentLiabilities;

	@Column(name="equity")
	private Double equity;

	@Column(name="revenue")
	private Double revenue;

	@Column(name="operating_expenses")
	private Double operatingExpenses;

	@Column(name="net_profit")
	private Double netProfit;

	@Column(name="roa")
	private Double roa;

	@Column(name="roe")
	private Double roe;

	@Column(name="liquidity_ratio")
	private Double liquidityRatio;

	@Column(name="quick_ratio")
	private Double quickRatio;
	

	public FinancialIndicators() {
	}

	public FinancialIndicators(Double annee, Double totalAssets, Double currentAssets, Double fixedAssets, Double totalLiabilities, Double currentLiabilities, Double nonCurrentLiabilities, Double equity, Double revenue, Double operatingExpenses, Double netProfit, Double roa, Double roe, Double liquidityRatio, Double quickRatio) {
	    this.annee = annee;
	    this.totalAssets = totalAssets;
	    this.currentAssets = currentAssets;
	    this.fixedAssets = fixedAssets;
	    this.totalLiabilities = totalLiabilities;
	    this.currentLiabilities = currentLiabilities;
	    this.nonCurrentLiabilities = nonCurrentLiabilities;
	    this.equity = equity;
	    this.revenue = revenue;
	    this.operatingExpenses = operatingExpenses;
	    this.netProfit = netProfit;
	    this.roa = roa;
	    this.roe = roe;
	    this.liquidityRatio = liquidityRatio;
	    this.quickRatio = quickRatio;
	}

	public FinancialIndicators(Long indicatorId, Double annee, Double totalAssets, Double currentAssets, Double fixedAssets, Double totalLiabilities, Double currentLiabilities, Double nonCurrentLiabilities, Double equity, Double revenue, Double operatingExpenses, Double netProfit, Double roa, Double roe, Double liquidityRatio, Double quickRatio) {
	    this.indicatorId = indicatorId;
	    this.annee = annee;
	    this.totalAssets = totalAssets;
	    this.currentAssets = currentAssets;
	    this.fixedAssets = fixedAssets;
	    this.totalLiabilities = totalLiabilities;
	    this.currentLiabilities = currentLiabilities;
	    this.nonCurrentLiabilities = nonCurrentLiabilities;
	    this.equity = equity;
	    this.revenue = revenue;
	    this.operatingExpenses = operatingExpenses;
	    this.netProfit = netProfit;
	    this.roa = roa;
	    this.roe = roe;
	    this.liquidityRatio = liquidityRatio;
	    this.quickRatio = quickRatio;
	}

	public Long getIndicatorId() {
	    return indicatorId;
	}

	public void setIndicatorId(Long indicatorId) {
	    this.indicatorId = indicatorId;
	}
	
	public Double getAnnee() {
	    return annee;
	}

	public void setAnnee(Double annee) {
	    this.annee = annee;
	}
	
	public Double getTotalAssets() {
	    return totalAssets;
	}

	public void setTotalAssets(Double totalAssets) {
	    this.totalAssets = totalAssets;
	}
	
	public Double getCurrentAssets() {
	    return currentAssets;
	}

	public void setCurrentAssets(Double currentAssets) {
	    this.currentAssets = currentAssets;
	}
	
	public Double getFixedAssets() {
	    return fixedAssets;
	}

	public void setFixedAssets(Double fixedAssets) {
	    this.fixedAssets = fixedAssets;
	}
	
	public Double getTotalLiabilities() {
	    return totalLiabilities;
	}

	public void setTotalLiabilities(Double totalLiabilities) {
	    this.totalLiabilities = totalLiabilities;
	}
	
	public Double getCurrentLiabilities() {
	    return currentLiabilities;
	}

	public void setCurrentLiabilities(Double currentLiabilities) {
	    this.currentLiabilities = currentLiabilities;
	}
	
	public Double getNonCurrentLiabilities() {
	    return nonCurrentLiabilities;
	}

	public void setNonCurrentLiabilities(Double nonCurrentLiabilities) {
	    this.nonCurrentLiabilities = nonCurrentLiabilities;
	}
	
	public Double getEquity() {
	    return equity;
	}

	public void setEquity(Double equity) {
	    this.equity = equity;
	}
	
	public Double getRevenue() {
	    return revenue;
	}

	public void setRevenue(Double revenue) {
	    this.revenue = revenue;
	}
	
	public Double getOperatingExpenses() {
	    return operatingExpenses;
	}

	public void setOperatingExpenses(Double operatingExpenses) {
	    this.operatingExpenses = operatingExpenses;
	}
	
	public Double getNetProfit() {
	    return netProfit;
	}

	public void setNetProfit(Double netProfit) {
	    this.netProfit = netProfit;
	}
	
	public Double getRoa() {
	    return roa;
	}

	public void setRoa(Double roa) {
	    this.roa = roa;
	}
	
	public Double getRoe() {
	    return roe;
	}

	public void setRoe(Double roe) {
	    this.roe = roe;
	}
	
	public Double getLiquidityRatio() {
	    return liquidityRatio;
	}

	public void setLiquidityRatio(Double liquidityRatio) {
	    this.liquidityRatio = liquidityRatio;
	}
	
	public Double getQuickRatio() {
	    return quickRatio;
	}

	public void setQuickRatio(Double quickRatio) {
	    this.quickRatio = quickRatio;
	}

}



