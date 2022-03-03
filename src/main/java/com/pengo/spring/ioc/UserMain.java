package com.pengo.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author pengo
 * @description:
 * @date 2022/3/1 00:04
 */
public class UserMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserService userService = context.getBean(UserService.class);
        User user = userService.login("bob@example.com", "password");
        System.out.println(user.toString());
        User register = userService.register("abc@spring.com", "abc", "abc");
        System.out.println(register.toString());
    }
}
