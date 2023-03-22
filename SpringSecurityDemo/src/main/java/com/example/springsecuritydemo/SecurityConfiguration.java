package com.example.springsecuritydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 *
 * SecurityConfiguration helps to add/edit the security to the existing system
 *
 * request with inputs comes from user to AuthenticationManager --> AuthenticationProvider ---> AuthenticationManager --> Principle
 */
@EnableWebSecurity
// Provides the security to the Web applications
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    /**
     * It is Authentication process ==> In which we're just validating the user has a correct credentials or not
     *
     * @param auth
     * @throws Exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
       /*
       * Using InMemoryAuthentication ==> creating our own users
       * /
            auth.inMemoryAuthentication()
                    .withUser("pramod")
                    .password("pramod")
                    .roles("USER")
                    .and()
                    .withUser("pratik")
                    .password("pratik")
                    .roles("ADMIN");
        */

        // Using already created user in the database with default schema
        auth.jdbcAuthentication()
                .dataSource(dataSource);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * It is a Authorization process ==> In which we are restricting the user from accessing services based on his role
     *
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception{

        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")     // Only accessible by admin
                .antMatchers("/user").hasRole("USER")   //Only accessible by user
                .antMatchers("/").permitAll()        // Everyone can access
                .and().formLogin();
    }

}
