package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import entities.BnsRule;

public interface BnsRuleRepository extends CrudRepository<BnsRule, Long> {

	@Query(value = "SELECT *FROM bns_rule t ORDER BY t.cz desc", nativeQuery = true)
	public List<BnsRule> listRuleDesc();

}
