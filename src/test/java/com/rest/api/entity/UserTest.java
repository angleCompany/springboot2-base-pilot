package com.rest.api.entity;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
public class UserTest {
    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User();
    }

    @Test
    public void getMsrl() {
        user.getMsrl();
    }

    @Test
    public void getUid() {
        user.getUid();
    }

    @Test
    public void getName() {
        user.getName();
    }

}