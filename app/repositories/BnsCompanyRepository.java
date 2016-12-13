package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import entities.BnsCompany;

public interface BnsCompanyRepository extends CrudRepository<BnsCompany, String> {

	@Query(value = "SELECT *FROM bns_company t WHERE t.city =?", nativeQuery = true)
	public List<BnsCompany> listByCity(String city);

	@Query(value = "SELECT *FROM bns_company t WHERE t.rank ='2'", nativeQuery = true)
	public List<BnsCompany> findService();

}
