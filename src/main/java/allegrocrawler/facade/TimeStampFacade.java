package allegrocrawler.facade;

import allegrocrawler.domain.TimeStamp;
import allegrocrawler.repository.TimeStampRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by demageron on 20.09.16.
 */
@RestController
@RequestMapping("/timestamp")
@PreAuthorize("hasRole(T(allegrocrawler.domain.RoleEnum).ROLE_ADMIN)")
public class TimeStampFacade {

    @Autowired
    TimeStampRepository timeStampRepository;

    @PreAuthorize("hasRole(T(allegrocrawler.domain.RoleEnum).ROLE_USER)")
    @RequestMapping("/hello")
    public List<TimeStamp> hello(){
        TimeStamp timeStamp = new TimeStamp();

        timeStampRepository.save(timeStamp);

        return Lists.newArrayList(timeStampRepository.findAll());
    }

    @RequestMapping("/helloSecured")
    public List<TimeStamp> helloSecured() {
        TimeStamp timeStamp = new TimeStamp();

        timeStampRepository.save(timeStamp);

        return Lists.newArrayList(timeStampRepository.findAll());
    }
}
