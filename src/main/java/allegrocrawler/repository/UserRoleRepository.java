package allegrocrawler.repository;

import allegrocrawler.domain.Role;
import allegrocrawler.domain.RoleEnum;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by demageron on 05.10.16.
 */
@Repository
public interface UserRoleRepository extends CrudRepository<Role, Integer> {
    Role findByRole(RoleEnum roleEnum);
}
