package bean;

import java.math.BigDecimal;

public class WalletForm {
	
	private String id;
	private BigDecimal allowance;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public BigDecimal getAllowance() {
		return allowance;
	}
	public void setAllowance(BigDecimal allowance) {
		this.allowance = allowance;
	}
	
	

}
