package com.perfios.srpingdemo.jdbc_templete;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Autowired
    DriverManagerDataSource driverManagerDataSource;

    private JdbcTemplate jdbcTemplate;

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        if(null==jdbcTemplate) {
            jdbcTemplate = new JdbcTemplate(driverManagerDataSource);
        }
        return jdbcTemplate;
    }

    @Bean
    public DriverManagerDataSource getDriverManagerDetails(){
        return new DriverManagerDataSource();
    }

    @Bean
    public Student getStudent(){
        return new Student();
    }

    @Bean
    public StudentDao getStudentDao(){
        return new StudentDao();
    }
}

