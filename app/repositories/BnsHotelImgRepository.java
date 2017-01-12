package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import entities.BnsHotelImg;

public interface BnsHotelImgRepository extends CrudRepository<BnsHotelImg, String> {
	
	@Query(value = "SELECT *FROM bns_hotel_img t WHERE t.hotel =?", nativeQuery = true)
	public List<BnsHotelImg> findByHotel(String hotel);

}
