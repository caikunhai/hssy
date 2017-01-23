package services;

import java.util.List;

import entities.BnsApply;
import entities.BnsApplyImg;

public interface ApplyService {
	
	public BnsApply save(BnsApply obj);
	
	public BnsApply search(String company);
	
	public List<BnsApply> list();

	public BnsApply get(String id);
	
	public BnsApplyImg saveImg(BnsApplyImg obj);
	
	public BnsApplyImg getImg(String id);
	
	public List<BnsApplyImg> listImgs(String apply);
	
	public void delImg(String id);

}
