package com.pengo.spring.ioc;

import com.pengo.spring.aop.MetricTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pengo
 * @description:
 * @date 2022/2/28 23:52
 */
@Component
public class UserService {
    @Autowired
    private MailService mailService;

//    public void setMailService(MailService mailService) {
//        this.mailService = mailService;
//    }

//    public UserService(MailService mailService) {
//        this.mailService = mailService;
//    }

    private List<User> users = new ArrayList<>(List.of( // users:
            new User(1, "bob@example.com", "password", "Bob"), // bob
            new User(2, "alice@example.com", "password", "Alice"), // alice
            new User(3, "tom@example.com", "password", "Tom"))); // tom

    public User login(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equalsIgnoreCase(password)) {
                mailService.sendLoginMail(user);
                return user;
            }
        }
        throw new RuntimeException("login failed");
    }

    public User getUser(int id) {
        return this.users.stream().filter(user -> user.getId() == id).findFirst().orElseThrow();
    }

    @MetricTime("register")
    public User register(String email, String password, String name) {
        users.forEach(user -> {
            if (user.getEmail().equals(email)) {
                throw new RuntimeException("email exist");
            }
        });
        User user = new User((users.stream().mapToInt(value -> value.getId()).max().getAsInt() + 1), email, password, name);
        users.add(user);
        mailService.sendRegistrationMail(user);
        return user;
    }
}
