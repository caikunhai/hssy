package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import entities.BnsService;

public interface BnsServiceRepository extends CrudRepository<BnsService, String> {

	@Query(value = "SELECT *FROM bns_service t WHERE t.company =?", nativeQuery = true)
	public List<BnsService> listByCompany(String company);

}
