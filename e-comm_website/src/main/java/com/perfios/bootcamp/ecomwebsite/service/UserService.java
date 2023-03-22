package com.perfios.bootcamp.ecomwebsite.service;

import com.perfios.bootcamp.ecomwebsite.beans.User;
import com.perfios.bootcamp.ecomwebsite.exception.UserNotFoundException;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(int id) throws UserNotFoundException;

    void saveUser(User user);

    void deleteUserById(int id) throws UserNotFoundException;

    void deleteAllUsers();

    User updateUserDetails(int id) throws UserNotFoundException;

}
