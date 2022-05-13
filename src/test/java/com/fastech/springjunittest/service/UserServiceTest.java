package com.fastech.springjunittest.service;

import com.fastech.springjunittest.model.User;
import com.fastech.springjunittest.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    private User user = null;

    @BeforeEach
    public void createUserObject(){
        user = new User(3L, "bilal", "password", "MALE");
    }

    @Test
    public void getAllUsersTest(){
        when(userRepository.findAll()).thenReturn(Stream.of(
                new User(1L, "Fahad", "fahadpassword", "male"),
                new User(2L, "shahzad", "shahzad", "male"))
                .collect(Collectors.toList()));
        assertEquals(2, userService.getAllUsers().size());
    }

    @Test
    public void addUser(){
        when(userRepository.save(user)).thenReturn(user);
        assertEquals(3L, userService.addUser(user).getId());
        assertNotEquals("fahad", userService.addUser(user).getUsername());
    }

    @Test
    public void findByUserId(){
        when(userRepository.findById(user.getId())).thenReturn(Optional.ofNullable(user));
        assertEquals("bilal", userService.findByUserId(user.getId()).get().getUsername());
    }
}