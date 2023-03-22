package com.perfios.bootcamp.ecomwebsite.repository;

import com.perfios.bootcamp.ecomwebsite.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
    Optional<User> findByEmailId(String emailId);
//    Optional<MyUser> findByEmail(String email);
}
