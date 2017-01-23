package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import entities.BnsApplyImg;

public interface BnsApplyImgRepository extends CrudRepository<BnsApplyImg, String> {

	@Query(value = "SELECT * FROM bns_apply_img t WHERE t.apply =?", nativeQuery = true)
	public List<BnsApplyImg> listImgs(String apply);

	@Modifying
	@Transactional
	@Query("DELETE from bns_apply_img WHERE apply=?")
	public void remove(String apply);

}
