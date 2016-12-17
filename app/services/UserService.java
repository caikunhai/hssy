package services;

import java.util.List;

import entities.BnsUser;
import entities.SysMenu;

public interface UserService {
	
	public BnsUser saveSysUser(BnsUser obj);
	
	public BnsUser login(String username,String password);
	
	public BnsUser findByUsername(String username);

	public BnsUser get(String id);

	public Iterable<BnsUser> listAll();

	public BnsUser findByToken(String token);
	
	public List<SysMenu> findMenu(int role);

	public List<BnsUser> listEmployeeByToken(String token);

}
