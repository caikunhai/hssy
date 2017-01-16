package bean;

import java.math.BigDecimal;

public class TempForm {
	private String company;
	private String business;
	private String site;
	private BigDecimal siteMoney;
	private String hotel;
	private BigDecimal hotelMoney;
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public BigDecimal getSiteMoney() {
		return siteMoney;
	}
	public void setSiteMoney(BigDecimal siteMoney) {
		this.siteMoney = siteMoney;
	}
	public String getHotel() {
		return hotel;
	}
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	public BigDecimal getHotelMoney() {
		return hotelMoney;
	}
	public void setHotelMoney(BigDecimal hotelMoney) {
		this.hotelMoney = hotelMoney;
	}
	

}
