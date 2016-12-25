package services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.BnsFileRepository;
import repositories.SysMenuRepository;
import repositories.SysMenuRoleRepository;
import services.SystemService;
import entities.BnsFile;
import entities.SysMenu;
import entities.SysMenuRole;

@Service("systemService")
public class SystemServiceImpl implements SystemService {
	
	@Autowired
	private SysMenuRoleRepository menuRoleRepository;
	
	@Autowired
	private SysMenuRepository menuRepository;
	
	@Autowired
	private BnsFileRepository fileRepository;

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

	@Override
	public BnsFile saveFile(BnsFile obj) {
		// TODO 自动生成的方法存根
		return fileRepository.save(obj);
	}

	@Override
	public List<BnsFile> listFile(String father) {
		// TODO 自动生成的方法存根
		return fileRepository.listByFather(father);
	}

	@Override
	public void delFile(Long id) {
		// TODO 自动生成的方法存根
		if(fileRepository.exists(id)){
			fileRepository.delete(id);
		}
	}

}
