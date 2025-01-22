package labs.intratech.services;

import labs.intratech.models.Users;
import org.springframework.stereotype.Service;
import labs.intratech.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService  {
	private final UsersRepository usersRepository;

	@Autowired
	public UsersService(UsersRepository usersRepository) {
	    this.usersRepository = usersRepository;
	}

	public List<Users> getAllUsers() {
	    return usersRepository.findAll();
	}  

	public Users getUsersById(Long id) {
	    Optional<Users> users = usersRepository.findById(id);
	    if (users.isPresent()) {
	       return users.get();
	    } else {
	       throw new RuntimeException("Users not found with id " + id);
	    }
	}

	public Users createUsers(Users users) {
	    return usersRepository.save(users);
	}

	public Users updateUsers(Long id, Users users) {
	    Optional<Users> existingUsers = usersRepository.findById(id);
	       if (existingUsers.isPresent()) {
		       users.setUsersid(id);
	             return usersRepository.save(users);
	       } else {
	          throw new RuntimeException("Users not found with id " + id);
	       }
	}

	public void deleteUsers(Long id) {
	    usersRepository.deleteById(id);
	}

}



