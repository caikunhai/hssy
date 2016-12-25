package services;

import java.util.List;

import entities.BnsFile;
import entities.SysMenu;
import entities.SysMenuRole;

public interface SystemService {

	public void removeMenuRole(int role);

	public SysMenuRole saveMenuRole(SysMenuRole obj);

	public Iterable<SysMenu> listMenu();
	
	public BnsFile saveFile(BnsFile obj);
	
	public List<BnsFile> listFile(String father);
	
	public void delFile(Long id);

}
