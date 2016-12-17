package services;

import java.util.List;

import entities.BnsSite;

public interface SiteService {
	
	public BnsSite save(BnsSite obj);
	
	public BnsSite get(String id);
	
	public List<Object> listAll();
	
	public List<BnsSite> searchByCompany(String company);

}
