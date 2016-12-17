package services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.BnsClothes;
import repositories.BnsClothesRepository;
import services.ClothService;

@Service("clothService")
public class ClothServiceImpl implements ClothService {
	
	@Autowired
	private BnsClothesRepository clothesRepository;

	@Override
	public BnsClothes save(BnsClothes obj) {
		// TODO Auto-generated method stub
		return clothesRepository.save(obj);
	}

	@Override
	public BnsClothes get(String id) {
		// TODO Auto-generated method stub
		return clothesRepository.findOne(id);
	}

	@Override
	public List<Object> listAll() {
		// TODO Auto-generated method stub
		return clothesRepository.listAll();
	}

	@Override
	public List<BnsClothes> search(String company) {
		// TODO Auto-generated method stub
		return clothesRepository.findByCompany(company);
	}

}
