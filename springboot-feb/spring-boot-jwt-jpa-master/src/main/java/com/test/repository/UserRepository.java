package com.test.repository;
import org.springframework.data.repository.CrudRepository;

import com.test.model.UserDao;
public interface UserRepository extends CrudRepository<UserDao, Integer> {
    UserDao findByUsername(String username);
}