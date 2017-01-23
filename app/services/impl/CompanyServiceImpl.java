package services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.BnsCompany;
import repositories.BnsCompanyRepository;
import services.CompanyService;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private BnsCompanyRepository companyRepository;
	

	@Override
	public BnsCompany save(BnsCompany obj) {
		// TODO 自动生成的方法存根
		return companyRepository.save(obj);
	}

	@Override
	public List<BnsCompany> listByCity(String city) {
		// TODO 自动生成的方法存根
		return companyRepository.listByCity(city);
	}

	@Override
	public Iterable<BnsCompany> list() {
		// TODO 自动生成的方法存根
		return companyRepository.findAll();
	}

	@Override
	public BnsCompany get(String id) {
		// TODO 自动生成的方法存根
		return companyRepository.findOne(id);
	}

	@Override
	public BnsCompany getByToken(String token) {
		// TODO 自动生成的方法存根
		return companyRepository.getByToken(token);
	}

	@Override
	public void detele(BnsCompany obj) {
		// TODO 自动生成的方法存根
		companyRepository.delete(obj);
	}

	@Override
	public List<BnsCompany> findService() {
		// TODO 自动生成的方法存根
		return companyRepository.findService();
	}

}
