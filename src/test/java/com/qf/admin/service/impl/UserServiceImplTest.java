package com.qf.admin.service.impl;

import com.qf.admin.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserServiceImplTest {
    @Test
    public void saveUser() throws Exception {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-service1.xml");
        UserService bean = ctx.getBean("userServiceImpl", UserService.class);
        bean.saveUser();
    }
}