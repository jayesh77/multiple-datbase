package com.example.multiple_datbase.config.secondWayToConfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean(name = "primaryDataSourceBean")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource firstDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public JdbcTemplate primaryJdbcTemplate(DataSource primaryDataSourceBean){
        return new JdbcTemplate(primaryDataSourceBean);
    }

    @Bean(name = "secondDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource secondDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public JdbcTemplate secondaryJdbcTemplate(DataSource secondDataSource){
        return new JdbcTemplate(secondDataSource);
    }
}
