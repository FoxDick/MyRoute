package online.myroute.repositories;

import online.myroute.model.db.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByName(String name);
}
