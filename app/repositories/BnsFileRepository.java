package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import entities.BnsFile;

public interface BnsFileRepository extends CrudRepository<BnsFile, Long> {

	@Query(value = "SELECT *FROM bns_file t WHERE t.father =?", nativeQuery = true)
	public List<BnsFile> listByFather(String father);

}
