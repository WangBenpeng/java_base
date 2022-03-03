package com.pengo.spring.jdbc;

import com.pengo.spring.jdbc.dao.UserDao;
import com.pengo.spring.jdbc.service.JdbcConfig;
import com.pengo.spring.jdbc.service.User;
import com.pengo.spring.jdbc.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author pengo
 * @description:
 * @date 2022/3/1 22:12
 */
@ComponentScan
@Configuration
public class JdbcMain {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcMain.class);
        test2(context);
    }

    static void test2(ApplicationContext context) {
        UserDao userDao = context.getBean(UserDao.class);
        UserService userService = context.getBean(UserService.class);
        User register = userService.register("insert@spring.com", "password", "insert");
        User byId = userDao.getById(0L);
        System.out.println(byId);
        userDao.deleteById(0L);
        List<User> all = userDao.getAll(10);
        System.out.println(all);
    }

    static void test1() {
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcMain.class);
        UserService userService = context.getBean(UserService.class);
        User register = userService.register("insert@spring.com", "password", "insert");
        User register2 = userService.register("abc@abc.com", "password", "abc");
        System.out.println("register:\n" + register);
        User userById = userService.getUserById(register.getId());
        System.out.println("userById:\n" + userById);
        register.setName("update");
        userService.updateUser(register);
        User userByEmail = userService.getUserByEmail("insert@spring.com");
        System.out.println("userByEmail:\n" + userByEmail);
        Long users = userService.getUsers();
        System.out.println("users:" + users);
        List<User> user = userService.getUser(1);
        System.out.println(user);
    }
}
