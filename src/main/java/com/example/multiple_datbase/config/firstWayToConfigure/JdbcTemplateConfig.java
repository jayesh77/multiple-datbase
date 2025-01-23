//package com.example.multiple_datbase.config.firstWayToConfigure;
//
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class JdbcTemplateConfig {
//
//    @Bean
//    public JdbcTemplate primaryJdbcTemplate(DataSource primaryDataSource){
//        return new JdbcTemplate(primaryDataSource);
//    }
//
//    @Bean
//    public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource") DataSource secondaryDataSource){
//        return new JdbcTemplate(secondaryDataSource);
//    }
//}