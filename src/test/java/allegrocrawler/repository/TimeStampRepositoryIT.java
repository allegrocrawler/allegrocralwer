package allegrocrawler.repository;

import allegrocrawler.domain.TimeStamp;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.annotation.Resource;

/**
 * Created by demageron on 20.09.16.
 */
@ContextConfiguration("classpath:test-context.xml")
public class TimeStampRepositoryIT extends AbstractTransactionalJUnit4SpringContextTests {

    @Resource
    TimeStampRepository timeStampRepository;

    @Test
    public void shouldSaveTimeStamp(){
        TimeStamp timeStamp = new TimeStamp();

        TimeStamp save = timeStampRepository.save(timeStamp);

        Assert.assertNotNull(save);
    }
}
