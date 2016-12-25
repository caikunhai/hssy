package services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.BnsRechargeRepository;
import repositories.BnsRuleRepository;
import services.RechargeService;
import entities.BnsRecharge;
import entities.BnsRule;

@Service("rechargeService")
public class RechargeServiceImpl implements RechargeService {
	
	@Autowired
	private BnsRechargeRepository rechargeRepository;
	
	@Autowired
	private BnsRuleRepository ruleRepository;
	

	@Override
	public BnsRecharge save(BnsRecharge obj) {
		// TODO Auto-generated method stub
		return rechargeRepository.save(obj);
	}

	@Override
	public BnsRecharge findByCode(String code) {
		// TODO Auto-generated method stub
		return rechargeRepository.findByCode(code);
	}

	@Override
	public Iterable<BnsRecharge> list() {
		// TODO Auto-generated method stub
		return rechargeRepository.findAll();
	}

	@Override
	public BnsRecharge get(String id) {
		// TODO Auto-generated method stub
		return rechargeRepository.findOne(id);
	}

	@Override
	public List<BnsRecharge> listByToken(String token) {
		// TODO 自动生成的方法存根
		return rechargeRepository.listByToken(token);
	}

	@Override
	public BnsRule saveRule(BnsRule obj) {
		// TODO 自动生成的方法存根
		return ruleRepository.save(obj);
	}

	@Override
	public void delRule(Long id) {
		// TODO 自动生成的方法存根
		if(ruleRepository.exists(id)){
			ruleRepository.delete(id);
		}
	}

	@Override
	public List<BnsRule> listRuleDesc() {
		// TODO 自动生成的方法存根
		return ruleRepository.listRuleDesc();
	}

}
