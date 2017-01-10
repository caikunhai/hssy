package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import entities.BnsWorks;

public interface BnsWorksRepository extends CrudRepository<BnsWorks, String> {

	@Query(value = "SELECT *FROM bns_works t WHERE t.company=?", nativeQuery = true)
	public List<BnsWorks> listByCompany(String company);

}
