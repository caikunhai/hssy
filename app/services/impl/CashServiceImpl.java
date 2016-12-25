package services.impl;

import java.util.List;

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
	public List<BnsCash> listByToken(String token) {
		// TODO 自动生成的方法存根
		return cashRepository.listByToken(token);
	}

	@Override
	public List<BnsCash> listByAdmin() {
		// TODO 自动生成的方法存根
		return cashRepository.listByAdmin();
	}

	@Override
	public void delete(String id) {
		// TODO 自动生成的方法存根
		BnsCash obj =cashRepository.findOne(id);
		if(obj!=null){
			obj.setState(1);
			cashRepository.save(obj);
		}
	}


}
