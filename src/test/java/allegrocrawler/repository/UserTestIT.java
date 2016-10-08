package allegrocrawler.repository;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.annotation.Resource;

/**
 * Created by demageron on 08.10.16.
 */
@ContextConfiguration("classpath:test-context.xml")
public class UserTestIT extends AbstractTransactionalJUnit4SpringContextTests {

    @Resource
    private UserRepository userRepository;

    @Test
    public void userPermissionTest() {
        //TODO dopisać test na update ról
    }


}
