package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import entities.BnsHotel;

public interface BnsHotelRepository extends CrudRepository<BnsHotel, String> {

	@Query(value = "SELECT c.name AS company,t.name,t.description,t.address,t.star,t.type,t.price,t.created_time FROM bns_hotel t LEFT JOIN bns_company c ON t.company =c.id ", nativeQuery = true)
	public List<Object> listAll();

	@Query(value = "SELECT *FROM bns_hotel t WHERE t.company =?", nativeQuery = true)
	public List<BnsHotel> findByCompany(String company);

}
