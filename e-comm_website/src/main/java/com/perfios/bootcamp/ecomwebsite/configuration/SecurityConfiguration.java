package com.perfios.bootcamp.ecomwebsite.configuration;

import com.perfios.bootcamp.ecomwebsite.serviceimpl.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * Spring security configuration
 * Before call other rotes it checks if user is logged in or not
 * if yes then what is the role based on it provides the authorisation
 *
 * AuthenticationManager -> AuthenticationProvider -> User Details -> Data base
 *
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserDetailsService userDetailsService;

    @Autowired
    GoogleOAuth2Config oAuth2Config;


    /**
     * This methods provides the authentication
     * (validating based on some proofs)
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    /**
     * This method provides authorization
     * (giving the access to the authenticated users based on his/her role)
     * @param http
     * @throws Exception
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("ADMIN", "USER")
                .antMatchers("/cart/**","/bynow/**").hasAnyRole("ADMIN","USER")
                .antMatchers("/","/login","/register").permitAll()
                .and().formLogin()
                .loginPage("/login")
                .permitAll()
//                .usernameParameter("email")
//                .failureForwardUrl("/login?error=true")
                .successForwardUrl("/index")
                .and()
                .oauth2Login()
                .loginPage("/login")
                .successHandler(oAuth2Config)
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and()
                .exceptionHandling();
        http.csrf().disable();
    }

    /**
     * This method helps to encrypt and decrypt password
     * Here NoopPasswordEncoder means ==> None of the encryption and decryption algorithm is applied
     * @return
     */
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
