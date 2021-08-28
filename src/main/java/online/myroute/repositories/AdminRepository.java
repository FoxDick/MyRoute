package online.myroute.repositories;

import online.myroute.model.db.AdminEntity;
import org.springframework.data.repository.CrudRepository;


public interface AdminRepository extends CrudRepository<AdminEntity, Long> {

    AdminEntity findById(Integer id);

}
