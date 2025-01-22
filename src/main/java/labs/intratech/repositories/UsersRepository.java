package labs.intratech.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import labs.intratech.models.Users;


public interface UsersRepository extends JpaRepository<Users, Long>,CrudRepository<Users,Long> {

    public Users findUsersByEmail(String email);
}



