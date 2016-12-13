package services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.BnsUser;
import entities.SysMenu;
import repositories.BnsUserRepository;
import repositories.SysMenuRepository;
import services.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private BnsUserRepository userRepository;
	
	@Autowired
	private SysMenuRepository menuRepository;
	
	@Override
	public BnsUser saveSysUser(BnsUser obj) {
		// TODO 自动生成的方法存根
		return userRepository.save(obj);
	}

	@Override
	public BnsUser login(String username, String password) {
		// TODO 自动生成的方法存根
		return userRepository.login(username, password);
	}

	@Override
	public BnsUser findByUsername(String username) {
		// TODO 自动生成的方法存根
		return userRepository.findByUsername(username);
	}

	@Override
	public BnsUser get(String id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	@Override
	public Iterable<BnsUser> listAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public BnsUser findByToken(String token) {
		// TODO Auto-generated method stub
		return userRepository.findByToken(token);
	}

	@Override
	public List<SysMenu> findMenu(int role) {
		// TODO Auto-generated method stub
		return menuRepository.findByRole(role);
	}

	@Override
	public List<BnsUser> listByCompany(String company) {
		// TODO Auto-generated method stub
		return userRepository.listByCompany(company);
	}

}
