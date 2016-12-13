package services;

import entities.BnsCash;

public interface CashService {
	
	public BnsCash save(BnsCash obj);
	
	public BnsCash get(String id);
	
	public Iterable<BnsCash> list();
	
}
