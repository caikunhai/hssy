package bean;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderAddForm {
	
	private String id;
	private String takeTime;
	private String customer;
	private String idcard;
	private String mobile;
	private Integer people;
	private Integer num;
	private Integer pickup;
	private String remark;
	
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTakeTime() {
		return takeTime+" 00:00:00";
	}
	public void setTakeTime(String takeTime) {
		this.takeTime = takeTime;
	}
	public Integer getPickup() {
		return pickup;
	}
	public void setPickup(Integer pickup) {
		this.pickup = pickup;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getPeople() {
		return people;
	}
	public void setPeople(Integer people) {
		this.people = people;
	}
	
}
