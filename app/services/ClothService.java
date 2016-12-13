package services;

import java.util.List;

import entities.BnsClothes;

public interface ClothService {
	
	public BnsClothes save(BnsClothes obj);
	
	public BnsClothes get(String id);
	
	public List<BnsClothes> list();
	
	public List<BnsClothes> search(String company);

}
