package com.bwts.jdbc;

import javax.sql.DataSource;

//import com.tradeshift.commons.dao.CustomJdbcTemplate;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.jdbc.support.incrementer.PostgreSQLSequenceMaxValueIncrementer;

@Configuration
public class JdbcConfig {

    @Value("${database.url}") private String url;
    @Value("${database.user}") private String user;
    @Value("${database.pass}") private String pass;

    /*@Bean("db_migration_dataSource")
    public DataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(url);
        ds.setUsername(user);
        ds.setPassword(pass);
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setValidationQuery("SELECT NOW()");
        ds.setMaxTotal(50);
        ds.setMinIdle(5);
        ds.setRemoveAbandonedTimeout(900000);
        ds.setRemoveAbandonedOnMaintenance(true);

        ds.setTestOnBorrow(true);
        ds.setTestOnReturn(true);
        return new LazyConnectionDataSourceProxy(ds);
    }
*/
    /*@Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public com.bwts.jdbc.MigrationManager migrationManager() {
        return new com.bwts.jdbc.MigrationManager(dataSource(), "classpath*:/db/migrations*//*");
    }*/

    /*@Bean
    @DependsOn("*//*migrationManager")
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }*/

    /*@Bean
    @DependsOn("migrationManager")
    public CustomJdbcTemplate customJdbcTemplate() {
        PostgreSQLSequenceMaxValueIncrementer incrementer = new PostgreSQLSequenceMaxValueIncrementer();
        incrementer.setIncrementerName("idsequence");
        incrementer.setDataSource(dataSource());
        return new CustomJdbcTemplate(dataSource(), incrementer);
    }*/
}
