package com.perfios.bootcamp.ecomwebsite.serviceimpl;


import com.perfios.bootcamp.ecomwebsite.beans.User;
import com.perfios.bootcamp.ecomwebsite.exception.UserNotFoundException;
import com.perfios.bootcamp.ecomwebsite.repository.UserRepository;
import com.perfios.bootcamp.ecomwebsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);
        user.orElseThrow(()->new UserNotFoundException("No user Found with this id!!!"));
//        return user.get();
        return userRepository.findById(id).get();
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(int id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);
        user.orElseThrow(()-> new UserNotFoundException("User Not found wit this id: "));
        userRepository.deleteById(id);
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    @Override
    public User updateUserDetails(int id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);
        user.orElseThrow(()-> new UserNotFoundException("User Not found wit this id: "));
        return userRepository.findById(id).get();
    }

    public User getUserByEmailId(String email) throws UserNotFoundException {
        Optional<User> user = userRepository.findByEmailId(email);
        user.orElseThrow(()-> new UserNotFoundException("User Not fount with this Email, Please Enter a valid email id!!"));
        return userRepository.findByEmailId(email).get();
    }
}
