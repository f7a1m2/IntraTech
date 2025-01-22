package labs.intratech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import labs.intratech.models.Users;


public interface UsersRepository extends JpaRepository<Users, Long> {
}



