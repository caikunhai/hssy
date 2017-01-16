package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import entities.BnsOrder;

public interface BnsOrderRepository extends CrudRepository<BnsOrder, String> {

	@Query(value = "SELECT *FROM bns_order t WHERE t.code =?", nativeQuery = true)
	public BnsOrder findByCode(String code);

	@Query(value = "SELECT t.* FROM bns_order t LEFT JOIN bns_user u ON t.created_user =u.company WHERE u.token =?", nativeQuery = true)
	public List<BnsOrder> findByHostToken(String userId);

	@Query(value = "SELECT t.* FROM bns_order t LEFT JOIN bns_user u ON t.accept_user =u.company WHERE u.token =?", nativeQuery = true)
	public List<BnsOrder> findByServerToken(String userId);

	@Query(value = "SELECT * FROM bns_order t WHERE t.accept_user=? AND TO_DAYS(t.take_time)=TO_DAYS(?)", nativeQuery = true)
	public List<BnsOrder> findByCompanyAndTime(String company, String time);

}
