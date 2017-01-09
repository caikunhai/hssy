package services;

import java.util.List;

import entities.BnsService;

public interface ServService {

	public List<BnsService> listByCompany(String company);

	public BnsService get(String id);
	
	public BnsService save(BnsService obj);

}
