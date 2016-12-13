package repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import entities.SysArea;

public interface SysAreaRepository extends CrudRepository<SysArea, Long> {

	@Query(value = "SELECT *FROM sys_area t WHERE t.name =?", nativeQuery = true)
	public SysArea findByName(String name);

}
