package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import entities.BnsCompany;

public interface BnsCompanyRepository extends CrudRepository<BnsCompany, String> {

	@Query(value = "SELECT *FROM bns_company t WHERE t.rank ='2' AND t.state ='0' AND t.city =?", nativeQuery = true)
	public List<BnsCompany> listByCity(String city);

	@Query(value = "SELECT *FROM bns_company t WHERE t.rank ='2'", nativeQuery = true)
	public List<BnsCompany> findService();

	@Query(value = "SELECT t.* FROM bns_company t LEFT JOIN bns_user u ON t.id =u.company WHERE u.token =?", nativeQuery = true)
	public BnsCompany getByToken(String token);

}
