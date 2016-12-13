package repositories;

import org.springframework.data.repository.CrudRepository;

import entities.SysLog;

public interface SysLogRepository extends CrudRepository<SysLog, Long> {

}
