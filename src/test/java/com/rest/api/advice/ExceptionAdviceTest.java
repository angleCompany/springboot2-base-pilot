package com.rest.api.advice;

import com.rest.api.advice.exception.CUserNotFoundException;
import com.rest.api.service.ResponseService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExceptionAdviceTest {

    @Test
    public void userNotFoundException() {
        ExceptionAdvice exceptionAdvice = new ExceptionAdvice(new ResponseService());

    }

    @Before
    public void setUp() throws Exception {
    }
}