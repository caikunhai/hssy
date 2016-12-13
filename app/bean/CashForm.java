package bean;

import java.math.BigDecimal;

public class CashForm {
	
	private String code;//提现密码
	
	private BigDecimal money;//提现金额
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	
	

}
