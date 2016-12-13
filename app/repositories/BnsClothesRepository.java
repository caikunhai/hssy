package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import entities.BnsClothes;

public interface BnsClothesRepository extends CrudRepository<BnsClothes, String> {

	@Query(value = "SELECT *FROM bns_clothes t WHERE t.company =? AND t.state='0'", nativeQuery = true)
	public List<BnsClothes> findByCompany(String company);
	
	@Query(value = "SELECT *FROM bns_clothes t", nativeQuery = true)
	public List<BnsClothes> listAll();

}
