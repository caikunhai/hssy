package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import entities.BnsCash;

public interface BnsCashRepository  extends CrudRepository<BnsCash, String> {

	@Query(value = "SELECT *FROM bns_cash t WHERE t.created_user =? ORDER BY t.created_time DESC", nativeQuery = true)
	public List<BnsCash> findByCompany(String company);

}
