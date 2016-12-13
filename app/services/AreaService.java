package services;

import entities.SysArea;

public interface AreaService {
	
	public SysArea get(Long id);
	
	public SysArea save(SysArea obj);
	
	public Iterable<SysArea> list();
	
	public SysArea findByName(String name);

}
