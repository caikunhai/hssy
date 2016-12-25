package services;

import java.util.List;

import entities.BnsRecharge;
import entities.BnsRule;

public interface RechargeService {
	
	public BnsRecharge save(BnsRecharge obj);
	
	public BnsRecharge findByCode(String code);
	
	public Iterable<BnsRecharge> list();

	public BnsRecharge get(String id);

	public List<BnsRecharge> listByToken(String token);

	public BnsRule saveRule(BnsRule obj);

	public void delRule(Long id);

	public List<BnsRule> listRuleDesc();

}
