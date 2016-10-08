package allegrocrawler.configuration;

import allegrocrawler.domain.Role;
import allegrocrawler.domain.RoleEnum;
import allegrocrawler.domain.UserDefinition;
import allegrocrawler.domain.UserRole;
import allegrocrawler.repository.UserRepository;
import allegrocrawler.repository.UserRoleRepository;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by demageron on 08.10.16.
 */
@Slf4j
@Component
public class InitialScripts {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private void script001_initializeRoles() {
        Iterable<Role> all = userRoleRepository.findAll();
        if (all == null || Iterables.isEmpty(all)) {
            for (RoleEnum roleEnum : RoleEnum.values()) {
                Role role = new Role();
                role.setRole(roleEnum);

                userRoleRepository.save(role);
            }
        }
    }

    private void script002_setUserIfNone() {
        Iterable<UserDefinition> all = userRepository.findAll();

        if (Iterables.isEmpty(all)) {
            Role role = userRoleRepository.findByRole(RoleEnum.ROLE_USER);

            UserDefinition userDefinition = new UserDefinition();
            UserRole userRole = new UserRole();

            userRole.setUserDefinition(userDefinition);
            userRole.setRole(role);
            userDefinition.setRoles(Lists.newArrayList(userRole));
            userDefinition.setUsername("test");
            userDefinition.setPassword(passwordEncoder().encode("test"));

            userRepository.save(userDefinition);
            System.out.println();
        }
    }

    private void script003_setRolesOnNulls() {
        Iterable<UserDefinition> all = userRepository.findAll();
        Role role = userRoleRepository.findByRole(RoleEnum.ROLE_USER);
        for (UserDefinition userDefinition : all) {
            List<UserRole> roles = userDefinition.getRoles();
            if (roles == null || Iterables.isEmpty(roles)) {
                UserRole userRole = new UserRole();
                userRole.setUserDefinition(userDefinition);
                userRole.setRole(role);

                userDefinition.setRoles(Lists.newArrayList(userRole));
                userRepository.save(userDefinition);
            }
        }
    }

}
