package SpringDB.model;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import SpringDB.schema.Users;

public interface UserCrud extends JpaRepository<Users, Integer> {
	Optional<Users> findByEmail(String email);
}
