package bean;

import java.math.BigDecimal;

public class ServForm {
	private String id;
	private String name;
	private Integer unit;
	private Integer num;
	private Integer state;
	private BigDecimal money;
	private Integer additional;
	private BigDecimal price;
	private String remark;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getUnit() {
		return unit;
	}
	public void setUnit(Integer unit) {
		this.unit = unit;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public Integer getAdditional() {
		return additional;
	}
	public void setAdditional(Integer additional) {
		this.additional = additional;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}

}
