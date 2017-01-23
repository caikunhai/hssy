package bean;

import java.util.List;

public class ApplyForm {
	
	private String id;
	private String company;
	private String name;
	private String address;
	private String frName;
	private String frMobile;
	private String gos;
	private List<String> imgs;
	
	
	public List<String> getImgs() {
		return imgs;
	}

	public void setImgs(List<String> imgs) {
		this.imgs = imgs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}

	public String getFrMobile() {
		return frMobile;
	}

	public void setFrMobile(String frMobile) {
		this.frMobile = frMobile;
	}

	public String getGos() {
		return gos;
	}

	public void setGos(String gos) {
		this.gos = gos;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}


