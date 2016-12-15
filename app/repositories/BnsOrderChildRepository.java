package repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import entities.BnsOrderChild;

public interface BnsOrderChildRepository extends CrudRepository<BnsOrderChild, String> {

	@Query(value = "SELECT *FROM bns_order_child t WHERE t.order_id =?", nativeQuery = true)
	public BnsOrderChild findByOrderId(String orderId);

}
