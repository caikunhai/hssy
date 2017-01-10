package services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.BnsWorks;
import repositories.BnsWorksRepository;
import services.WorkService;

@Service("workService")
public class WorkServiceImpl implements WorkService {
	
	@Autowired
	private BnsWorksRepository worksRepository;

	@Override
	public List<BnsWorks> listByCompany(String company) {
		// TODO Auto-generated method stub
		return worksRepository.listByCompany(company);
	}

	@Override
	public BnsWorks save(BnsWorks obj) {
		// TODO Auto-generated method stub
		return worksRepository.save(obj);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		worksRepository.delete(id);
	}

}
