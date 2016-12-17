package services;

import java.util.List;

import entities.BnsCompany;

public interface CompanyService {
	
	public List<BnsCompany> listByCity(String city);
	
	public BnsCompany save(BnsCompany obj);
	
	public Iterable<BnsCompany> list();
	
	public BnsCompany get(String id);

	public BnsCompany getByToken(String token);

	public void detele(BnsCompany obj);
	
	public List<BnsCompany> findService();

}
