package pg.repository;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//@Configuration
public class PGSQLDataSourceConfiguration {

//    @Bean
//    @ConfigurationProperties(prefix = "datasource.pgsql")
    public DataSourceProperties pgsqlDataSourceProperties() {
        return new DataSourceProperties();
    }
//    @Bean
    public DataSource pgsqlDataSource() {
        return pgsqlDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

}
