package services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.BnsServiceRepository;
import services.ServService;
import entities.BnsService;

@Service("servService")
public class ServServiceImpl implements ServService {
	
	@Autowired
	private BnsServiceRepository servRepository;

	@Override
	public List<BnsService> listByCompany(String company) {
		// TODO 自动生成的方法存根
		return servRepository.listByCompany(company);
	}

	@Override
	public BnsService get(String id) {
		// TODO 自动生成的方法存根
		return servRepository.findOne(id);
	}

	@Override
	public BnsService save(BnsService obj) {
		// TODO 自动生成的方法存根
		return servRepository.save(obj);
	}

}
