package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import entities.BnsUser;

public interface BnsUserRepository extends CrudRepository<BnsUser, String> {

	@Query(value = "SELECT *FROM bns_user t WHERE t.username =? AND t.password=? LIMIT 0,1", nativeQuery = true)
	public BnsUser login(String username, String password);

	@Query(value = "SELECT *FROM bns_user t WHERE t.username =? LIMIT 0,1", nativeQuery = true)
	public BnsUser findByUsername(String username);

	@Query(value = "SELECT *FROM bns_user t WHERE t.token =? LIMIT 0,1", nativeQuery = true)
	public BnsUser findByToken(String token);

	@Query(value = "SELECT *FROM bns_user t WHERE t.company =?", nativeQuery = true)
	public List<BnsUser> listByCompany(String company);

}
