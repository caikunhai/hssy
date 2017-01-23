package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import entities.BnsApply;

public interface BnsApplyRepository extends CrudRepository<BnsApply, String> {
	
	@Query(value = "SELECT * FROM bns_apply t WHERE t.company =?", nativeQuery = true)
	public BnsApply search(String company);
	
	@Query(value = "SELECT * FROM bns_apply t WHERE t.state is null", nativeQuery = true)
	public List<BnsApply> list();

}
