package com.perfios.bootcamp.ecomwebsite.beans;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {UserTest.class})
class UserTest {
    private static final String MESSAGE_ONE = "User properties are not set correctly in the constructor";
    private static final String MESSAGE_TWO = "User details returned by toString() are not correct";
    private User user;

    @BeforeEach
    public void setUp() {
        user = new User(1,"pramod","pramod","pramod","pramod@gmail.com","6362063788",true,"ROLE_ADMIN");
    }

    @AfterEach
    public void tearDown() {
        user = null;
    }

    @Test
    public void givenValidUserValuesWhenCreatedThenSetProperties() {
        assertEquals(1, user.getId(), MESSAGE_ONE);
        assertEquals("pramod", user.getUserName(), MESSAGE_ONE);
        assertEquals("6362063788", user.getMobileNumber(), MESSAGE_ONE);
        assertEquals("pramod@gmail.com", user.getEmailId(), MESSAGE_ONE);
    }

    @Test
    public void givenValidUserValuesThenReturnUserDetails() {
        String details = user.toString();
        assertTrue(details.contains("id=1, userName=pramod"), MESSAGE_TWO);
        assertTrue(details.contains("password=pramod"), MESSAGE_TWO);
    }
}