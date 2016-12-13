package services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.BnsSite;
import repositories.BnsSiteRepository;
import services.SiteService;

@Service("siteService")
public class SiteServiceImpl  implements SiteService {
	
	@Autowired
	private BnsSiteRepository siteRepository;

	@Override
	public BnsSite save(BnsSite obj) {
		// TODO Auto-generated method stub
		return siteRepository.save(obj);
	}

	@Override
	public BnsSite get(String id) {
		// TODO Auto-generated method stub
		return siteRepository.findOne(id);
	}

	@Override
	public List<BnsSite> listAll() {
		// TODO Auto-generated method stub
		return siteRepository.listAll();
	}

	@Override
	public List<BnsSite> search(String company) {
		// TODO Auto-generated method stub
		return siteRepository.findByCompany(company);
	}

}
