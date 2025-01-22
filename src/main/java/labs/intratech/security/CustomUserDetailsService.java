package labs.intratech.security;

import labs.intratech.models.Users;
import labs.intratech.repositories.UsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UsersRepository userRepository;

    // Constructeur pour injecter le UsersRepository
    public CustomUserDetailsService(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Getter pour userRepository
    public UsersRepository getUserRepository() {
        return userRepository;
    }

    // Setter pour userRepository
    public void setUserRepository(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = userRepository.findUsersByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }
}
