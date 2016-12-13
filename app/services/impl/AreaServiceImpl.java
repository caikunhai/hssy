package services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.SysArea;
import repositories.SysAreaRepository;
import services.AreaService;

@Service("areaService")
public class AreaServiceImpl implements AreaService {
	
	@Autowired
	private SysAreaRepository areaRepository;

	@Override
	public SysArea get(Long id) {
		// TODO Auto-generated method stub
		return areaRepository.findOne(id);
	}

	@Override
	public SysArea save(SysArea obj) {
		// TODO Auto-generated method stub
		return areaRepository.save(obj);
	}

	@Override
	public Iterable<SysArea> list() {
		// TODO Auto-generated method stub
		return areaRepository.findAll();
	}

	@Override
	public SysArea findByName(String name) {
		// TODO Auto-generated method stub
		return areaRepository.findByName(name);
	}

}
