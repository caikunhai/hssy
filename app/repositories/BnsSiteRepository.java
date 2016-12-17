package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import entities.BnsSite;

public interface BnsSiteRepository extends CrudRepository<BnsSite, String> {

	//机构名称、景点名称、景点简介、景点类型、景点门票、创建时间
	@Query(value = "SELECT c.name AS company, t.name,t.description,t.type,t.money,t.created_time FROM bns_site t LEFT JOIN bns_company c ON t.company =c.id WHERE t.state ='0'", nativeQuery = true)
	public List<Object> listAll();

	@Query(value = "SELECT *FROM bns_site t WHERE t.company=?", nativeQuery = true)
	public List<BnsSite> searchByCompany(String company);

}
