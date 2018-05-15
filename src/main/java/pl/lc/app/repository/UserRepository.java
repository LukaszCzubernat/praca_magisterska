package pl.lc.app.repository;

import org.springframework.data.repository.CrudRepository;
import pl.lc.app.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUserName(String userName);
}
