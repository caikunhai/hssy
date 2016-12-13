package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import entities.BnsHotel;

public interface BnsHotelRepository extends CrudRepository<BnsHotel, String> {

	@Query(value = "SELECT *FROM bns_hotel t", nativeQuery = true)
	public List<BnsHotel> listAll();

	@Query(value = "SELECT *FROM bns_hotel t WHERE t.company =? AND t.state='0'", nativeQuery = true)
	public List<BnsHotel> findByCompany(String company);

}
