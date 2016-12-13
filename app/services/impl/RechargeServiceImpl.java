package services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.BnsRecharge;
import repositories.BnsRechargeRepository;
import services.RechargeService;

@Service("rechargeService")
public class RechargeServiceImpl implements RechargeService {
	
	@Autowired
	private BnsRechargeRepository rechargeRepository;

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

}
