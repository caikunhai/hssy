package repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import entities.SysMenuRole;

public interface SysMenuRoleRepository  extends CrudRepository<SysMenuRole, Long> {

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM sys_menu_role WHERE role=?", nativeQuery = true)
	public void remove(int role);

}
