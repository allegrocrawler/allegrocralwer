package allegrocrawler.facade;

import allegrocrawler.domain.TimeStamp;
import allegrocrawler.repository.TimeStampRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by demageron on 20.09.16.
 */
@RestController
@RequestMapping("/timestamp")
public class TimeStampFacade {

    @Autowired
    TimeStampRepository timeStampRepository;

    @RequestMapping("/hello")
    public List<TimeStamp> hello(){
        TimeStamp timeStamp = new TimeStamp();

        timeStampRepository.save(timeStamp);

        return Lists.newArrayList(timeStampRepository.findAll());
    }
}
