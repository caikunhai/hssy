package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import entities.BnsSite;

public interface BnsSiteRepository extends CrudRepository<BnsSite, String> {

	@Query(value = "SELECT *FROM bns_site t", nativeQuery = true)
	public List<BnsSite> listAll();

	@Query(value = "SELECT *FROM bns_site t WHERE t.company =? AND t.state='0'", nativeQuery = true)
	public List<BnsSite> findByCompany(String company);

}
