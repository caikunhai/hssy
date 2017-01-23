package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import entities.BnsApplyImg;

public interface BnsApplyImgRepository extends CrudRepository<BnsApplyImg, String> {

	@Query(value = "SELECT * FROM bns_apply_img t WHERE t.apply =?", nativeQuery = true)
	public List<BnsApplyImg> listImgs(String apply);

	@Modifying
	@Query(value="DELETE from bns_apply_img WHERE apply=?",nativeQuery=true)
	public void remove(String apply);

}
