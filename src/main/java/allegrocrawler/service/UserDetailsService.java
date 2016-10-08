package allegrocrawler.service;

import allegrocrawler.domain.UserDefinition;
import allegrocrawler.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by demageron on 05.10.16.
 */
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDefinition byUsername = userRepository.findByUsername(username);

        return new User(byUsername.getUsername(), byUsername.getPassword(), byUsername.getRoles());
    }
}
