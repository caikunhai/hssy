package services;

import entities.BnsRecharge;

public interface RechargeService {
	
	public BnsRecharge save(BnsRecharge obj);
	
	public BnsRecharge findByCode(String code);
	
	public Iterable<BnsRecharge> list();

	public BnsRecharge get(String id);

}
