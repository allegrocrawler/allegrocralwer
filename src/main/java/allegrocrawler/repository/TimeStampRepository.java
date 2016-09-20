package allegrocrawler.repository;

import allegrocrawler.domain.TimeStamp;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by demageron on 20.09.16.
 */
public interface TimeStampRepository extends CrudRepository<TimeStamp, Integer> {
}
