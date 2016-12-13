package services;

import entities.SysMenu;
import entities.SysMenuRole;

public interface SystemService {

	void removeMenuRole(int role);

	SysMenuRole saveMenuRole(SysMenuRole obj);

	Iterable<SysMenu> listMenu();

}
