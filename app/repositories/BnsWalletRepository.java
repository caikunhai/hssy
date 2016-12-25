package repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import entities.BnsWallet;

public interface BnsWalletRepository extends CrudRepository<BnsWallet, String> {

	@Query(value = "SELECT *FROM bns_wallet t WHERE t.id =(SELECT u.company FROM bns_user u WHERE u.token=?)", nativeQuery = true)
	public BnsWallet findWalletByToken(String token);

}
