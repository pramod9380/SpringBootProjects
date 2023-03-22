package com.perfios.bootcamp.ecomwebsite.serviceimpl;

import com.perfios.bootcamp.ecomwebsite.beans.MyUserDetails;
import com.perfios.bootcamp.ecomwebsite.beans.User;
import com.perfios.bootcamp.ecomwebsite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    public static String username;

    @Autowired
    UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

//        Optional<User> user = userRepository.findByUserName(userName);
        Optional<User> user = userRepository.findByEmailId(userName);
        user.orElseThrow(() -> new UsernameNotFoundException("User Not found with this email: " + userName));
        username=userName;
        System.out.println("user: "+user.get().getPassword());

        return user.map(MyUserDetails::new).get();
    }
}

