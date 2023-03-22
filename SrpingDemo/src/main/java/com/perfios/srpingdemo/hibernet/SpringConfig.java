package com.perfios.srpingdemo.hibernet;

import org.springframework.context.annotation.Bean;

public class SpringConfig {


    @Bean
    public HibernateConf getHibernetConf(){
        return new HibernateConf();
    }

    @Bean
    public Department getDepartmentObject(){
        return new Department();
    }

    @Bean
    public DepartmentDao getDepartmentDao(){
        return new DepartmentDao();
    }
}
