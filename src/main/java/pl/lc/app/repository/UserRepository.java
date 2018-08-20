package pl.lc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lc.app.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);
}
