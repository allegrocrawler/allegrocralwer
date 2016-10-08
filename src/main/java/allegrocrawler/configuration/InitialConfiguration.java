package allegrocrawler.configuration;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by demageron on 08.10.16.
 */
@Slf4j
@Component
public class InitialConfiguration {

    @Autowired
    InitialScripts initialScripts;

    @PostConstruct
    public void runAll() {
        List<Method> methods = Lists.newArrayList(InitialScripts.class.getDeclaredMethods());
        methods.sort((method, method2) -> method.getName().compareTo(method2.getName()));

        methods.forEach(method -> {
            try {
                method.setAccessible(true);
                method.invoke(initialScripts);
            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error(e.getMessage(), e.getCause());
            }
        });
    }

}
