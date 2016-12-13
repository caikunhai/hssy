package services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.BnsCash;
import repositories.BnsCashRepository;
import services.CashService;

@Service("cashService")
public class CashServiceImpl implements CashService {
	
	@Autowired
	private BnsCashRepository cashRepository;

	@Override
	public BnsCash get(String arg0) {
		// TODO Auto-generated method stub
		return cashRepository.findOne(arg0);
	}

	@Override
	public BnsCash save(BnsCash obj) {
		// TODO Auto-generated method stub
		return cashRepository.save(obj);
	}

	@Override
	public Iterable<BnsCash> list() {
		// TODO Auto-generated method stub
		return cashRepository.findAll();
	}
	
	
	

}
