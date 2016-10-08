package allegrocrawler.configuration;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by demageron on 20.09.16.
 */
@Configuration
public class DatabaseConfig {

    public static final String DATABASE_URL = "DATABASE_URL";

    @Bean
    public DataSource dataSource() throws URISyntaxException {
        String env = System.getenv(DATABASE_URL);
        String property = System.getProperty(DATABASE_URL);

        String url = StringUtils.isEmpty(env) ? property : env;

        URI dbUri = new URI(url);

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        return DataSourceBuilder
                .create()
                .username(username)
                .password(password)
                .url(dbUrl)
                .build();
    }

}