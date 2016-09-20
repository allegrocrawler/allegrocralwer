package allegrocrawler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by demageron on 20.09.16.
 */
@Slf4j
@EnableJpaRepositories
@SpringBootApplication
public class Main {

    public static void main(String[] args) throws Exception {
        log.info("App starting");
        SpringApplication.run(Main.class, args);
    }

}
