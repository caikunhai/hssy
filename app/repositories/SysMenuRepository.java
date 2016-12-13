package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import entities.SysMenu;

public interface SysMenuRepository extends CrudRepository<SysMenu, Long> {
	
	@Query(value = "SELECT t.* FROM sys_menu t , sys_menu_role r WHERE t.id =r.menu AND r.role =?", nativeQuery = true)
	public List<SysMenu> findByRole(int role);

}
