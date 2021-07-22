package org.generation.UnicornsBackery.controller;

import org.generation.UnicornsBackery.model.Users;
import org.generation.UnicornsBackery.repositories.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    @Autowired
    private Optional<Users> user;

    private UserRepository userRepositoryMock = Mockito.mock(UserRepository.class);

    @Autowired
    private UserController userController = new UserController(userRepositoryMock);

    @BeforeEach
    void setUp() {
        Users user = new Users();
        user.setIdUsers(1);
        user.setEmail("admin@admin.com");
        user.setUser_name("admin");
        user.setPassword("12345678");
        user.setId_type_user(1);

        List<Users> users = new ArrayList<>();
        users.add(user);
        Mockito.when(userRepositoryMock.findAll()).thenReturn(users);
    }

    @Test
    void addNewUser() {
        Users user = new Users();
        user.setIdUsers(1);
        user.setEmail("admin@admin.com");
        user.setUser_name("admin");
        user.setPassword("12345678");
        user.setId_type_user(1);
        Assertions.assertEquals(userController.addNewUser(user),"Saved");
    }

    @Test
    void loginUser() {
        Users user = new Users();
        user.setEmail("admin@admin.com");
        user.setPassword("12345678");
        Users user2 = new Users();
        user2.setEmail("noadmin@admin.com");
        user2.setPassword("87654321");
        Assertions.assertEquals(userController.loginUser(user),"Logged");
        Assertions.assertEquals(userController.loginUser(user2),"No log");
    }
}