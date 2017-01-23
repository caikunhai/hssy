package services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.BnsApply;
import entities.BnsApplyImg;
import repositories.BnsApplyImgRepository;
import repositories.BnsApplyRepository;
import services.ApplyService;

@Service("applyService")
public class ApplyServiceImpl implements ApplyService {
	
	@Autowired
	private BnsApplyRepository applyRepository;
	
	@Autowired
	private BnsApplyImgRepository applyImgRepository;

	@Override
	public BnsApply save(BnsApply obj) {
		// TODO Auto-generated method stub
		return applyRepository.save(obj);
	}

	@Override
	public BnsApply search(String company) {
		// TODO Auto-generated method stub
		return applyRepository.search(company);
	}

	@Override
	public List<BnsApply> list() {
		// TODO Auto-generated method stub
		return applyRepository.list();
	}

	@Override
	public BnsApply get(String id) {
		// TODO Auto-generated method stub
		return applyRepository.findOne(id);
	}

	@Override
	public BnsApplyImg saveImg(BnsApplyImg obj) {
		// TODO Auto-generated method stub
		return applyImgRepository.save(obj);
	}

	@Override
	public List<BnsApplyImg> listImgs(String apply) {
		// TODO Auto-generated method stub
		return applyImgRepository.listImgs(apply);
	}

	@Override
	public void delImg(String apply) {
		// TODO Auto-generated method stub
		applyImgRepository.remove(apply);
	}

	@Override
	public BnsApplyImg getImg(String id) {
		// TODO Auto-generated method stub
		return applyImgRepository.findOne(id);
	}
	
}
