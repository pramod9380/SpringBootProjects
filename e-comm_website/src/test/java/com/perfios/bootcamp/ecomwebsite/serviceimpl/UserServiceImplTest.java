package com.perfios.bootcamp.ecomwebsite.serviceimpl;

import com.perfios.bootcamp.ecomwebsite.beans.User;
import com.perfios.bootcamp.ecomwebsite.exception.UserNotFoundException;
import com.perfios.bootcamp.ecomwebsite.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {UserServiceImplTest.class})
class UserServiceImplTest {

    private static final String MESSAGE01 = "No. of users are not retrieving properly from the database";
    private static final String MESSAGE02 = "When No User Found Then List Should Return Empty";
    private static final String MESSAGE03 = "When No User Found Then Throw User Not Found Exception";

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    public List<User> expectedUserList;

    @BeforeEach
    public void beforeEachTestMethod(){
        expectedUserList = new ArrayList<>();
    }

    @Test
    @Order(1)
    public void testGetAllUsersWhenUsersFoundThenReturnListSize(){
        Collections.addAll(expectedUserList,
                new User(1,"pramod","pramod","pramod","pramod@gmail.com","6362063788",true,"ROLE_ADMIN"),
                new User(2,"pavan","pavan","pavan","pavan@gmail.com","9380846575",true,"ROLE_USER")
        );
        when(userRepository.findAll()).thenReturn(expectedUserList);   // Mocking
        List<User> actualUserList = userService.getAllUsers();

        assertEquals(expectedUserList.size(),actualUserList.size(),MESSAGE01);
    }

    @Test
    @Order(2)
    public void testGetAllUsersWhenNoUserFoundThenReturnEmptyList(){
        when(userRepository.findAll()).thenReturn(expectedUserList);
        List<User> actualUserList = userService.getAllUsers();
        assertTrue(actualUserList.isEmpty(),MESSAGE02);
    }

    @Test
    @Order(3)
    public void testGetUserById() throws UserNotFoundException {

        User expectedUser = new User(1,"pramod","pramod","pramod","pramod@gmail.com","6362063788",true,"ROLE_ADMIN");

        when(userRepository.findById(1)).thenReturn(Optional.of(expectedUser));
        User actualUser = userService.getUserById(1);

        assertEquals(expectedUser.getId(),actualUser.getId());
        assertTrue(expectedUser.getUserName().equals(actualUser.getUserName()));
    }

    @Test
    @Order(4)
    public void testGetUserByIdWhenUserNotFoundThenThrowsUserNotFoundException(){
        when(userRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class,()->userService.getUserById(1),MESSAGE03);
    }

//    @Test
//    @Order(5)
//    public void testDeleteUserById() throws UserNotFoundException {
//        userService.deleteUserById(1);
//        verify(userRepository,times(1)).deleteById(1);
//    }

    @Test
    @Order(6)
    public void testDeleteUserByIdWhenUserNotFoundWithGivenIdThenThrowUserNotFoundException(){
        assertThrows(UserNotFoundException.class,()->userService.deleteUserById(1),MESSAGE03);
    }

    @Test
    @Order(7)
    public void testSaveUser(){
        User expectedUser = new User(1,"pramod","pramod","pramod","pramod@gmail.com","6362063788",true,"ROLE_ADMIN");
        userService.saveUser(expectedUser);
        verify(userRepository,times(1)).save(expectedUser);
    }

    @Test
    @Order(8)
    public void testDeleteAll(){
        userService.deleteAllUsers();
        verify(userRepository,times(1)).deleteAll();
    }

    @Test
    @Order(9)
    public void testUpdateUserDetails() throws UserNotFoundException {
        User expectedUser = new User(1,"pramod","pramod","pramod","pramod@gmail.com","6362063788",true,"ROLE_ADMIN");

        when(userRepository.findById(1)).thenReturn(Optional.of(expectedUser));
        User actualUser = userService.updateUserDetails(1);

        assertEquals(expectedUser.getId(),actualUser.getId());
        assertTrue(expectedUser.getUserName().equals(actualUser.getUserName()));
    }

    @Test
    @Order(10)
    public void testUpdateUserDetailsWhenUserNotFoundWithGivenIdThenThrowUserNotFoundException() {
        when(userRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class,()->userService.getUserById(1),MESSAGE03);
    }

    @AfterEach
    public void afterEachTestMethod(){
        expectedUserList = null;
    }
}