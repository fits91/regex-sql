package ua.org.fits;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;


@Configuration
@Profile("dev")
public class Config {
    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource getDataSource() {
        return DataSourceBuilder.create().build();
    }
}
