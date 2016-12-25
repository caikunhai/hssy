package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import entities.BnsCash;

public interface BnsCashRepository  extends CrudRepository<BnsCash, String> {

	@Query(value = "SELECT *FROM bns_cash t WHERE t.state ='0' AND t.created_user =(SELECT u.company FROM bns_user u WHERE u.token=? ORDER BY t.created_time DESC)", nativeQuery = true)
	public List<BnsCash> listByToken(String token);

	@Query(value = "SELECT t.id,t.code,t.money,t.type,t.state,t.update_time,t.created_time,c.name AS created_user,t.checked_user FROM bns_cash t LEFT JOIN bns_company c ON t.created_user =c.id ORDER BY t.created_time DESC", nativeQuery = true)
	public List<BnsCash> listByAdmin();

}
