package com.company.streamservice.controller;

import com.company.streamservice.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private Mockmvc mockmvc;

    @MockBean
    private User repo;

    private ObjectMapper mapper = new ObjectMapper();

    private User repoUser;
    private String repoJson;
    private List<User> allUsers = new ArrayList<>();
    private String allUsersJson;

    @Before
    public void setUp() throws Exception {
        repoUser = new User();
        repoUser.setUserId();
        repoUser.setTitle();
        repoUser.setDescription();
        repoUser.setLink();
        repoUser.setCategory();

        repoJson = mapper.writeValueAsString();


    }
}