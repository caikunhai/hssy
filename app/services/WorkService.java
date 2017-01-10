package services;

import java.util.List;

import entities.BnsWorks;

public interface WorkService {
	
	public BnsWorks save(BnsWorks obj);
	
	public void delete(String id);
	
	public List<BnsWorks> listByCompany(String company);

}
