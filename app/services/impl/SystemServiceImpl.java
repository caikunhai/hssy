package services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.SysMenu;
import entities.SysMenuRole;
import repositories.SysMenuRepository;
import repositories.SysMenuRoleRepository;
import services.SystemService;

@Service("systemService")
public class SystemServiceImpl implements SystemService {
	
	@Autowired
	private SysMenuRoleRepository menuRoleRepository;
	
	@Autowired
	private SysMenuRepository menuRepository;

	@Override
	public void removeMenuRole(int role) {
		// TODO Auto-generated method stub
		menuRoleRepository.remove(role);
	}

	@Override
	public SysMenuRole saveMenuRole(SysMenuRole obj) {
		// TODO Auto-generated method stub
		return menuRoleRepository.save(obj);
	}

	@Override
	public Iterable<SysMenu> listMenu() {
		// TODO Auto-generated method stub
		return menuRepository.findAll();
	}

}
