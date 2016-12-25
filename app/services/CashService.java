package services;

import java.util.List;

import entities.BnsCash;

public interface CashService {
	
	public BnsCash save(BnsCash obj);
	
	public BnsCash get(String id);
	
	public List<BnsCash> listByToken(String token);

	public List<BnsCash> listByAdmin();

	public void delete(String id);
	
}
