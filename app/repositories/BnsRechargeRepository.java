package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import entities.BnsRecharge;

public interface BnsRechargeRepository extends CrudRepository<BnsRecharge, String> {

	@Query(value = "SELECT *FROM bns_recharge t WHERE t.code =?", nativeQuery = true)
	public BnsRecharge findByCode(String code);

	@Query(value = "SELECT *FROM bns_recharge t WHERE t.created_user =(SELECT u.company FROM bns_user u WHERE u.token=?)", nativeQuery = true)
	public List<BnsRecharge> listByToken(String token);

}
