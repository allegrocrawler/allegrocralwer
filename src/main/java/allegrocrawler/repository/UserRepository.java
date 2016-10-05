package allegrocrawler.repository;

import allegrocrawler.domain.UserDefinition;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by demageron on 05.10.16.
 */
public interface UserRepository extends CrudRepository<UserDefinition, Integer> {
    UserDefinition findByUsername(String username);
}
