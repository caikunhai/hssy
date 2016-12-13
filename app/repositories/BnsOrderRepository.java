package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import entities.BnsOrder;

public interface BnsOrderRepository extends CrudRepository<BnsOrder, String> {

	@Query(value = "SELECT *FROM bns_order t WHERE t.code =?", nativeQuery = true)
	public BnsOrder findByCode(String code);

	@Query(value = "SELECT *FROM bns_order t WHERE t.state!=5 AND t.created_user =?", nativeQuery = true)
	public List<BnsOrder> listByHost(String userId);

	@Query(value = "SELECT *FROM bns_order t WHERE t.state!=5 AND t.accept_user =?", nativeQuery = true)
	public List<BnsOrder> listByServer(String userId);

}
