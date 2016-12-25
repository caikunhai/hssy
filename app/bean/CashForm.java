package bean;

import java.math.BigDecimal;

import play.data.validation.Constraints.MaxLength;
import play.data.validation.Constraints.Min;
import play.data.validation.Constraints.MinLength;
import play.data.validation.Constraints.Required;

public class CashForm {
	
	@Required
	@MinLength(value=6)
	@MaxLength(value=30)
	private String code;//提现密码
	
	@Required
	@Min(value=1)
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
