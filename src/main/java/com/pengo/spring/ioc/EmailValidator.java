package com.pengo.spring.ioc;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author pengo
 * @description:
 * @date 2022/3/1 11:35
 */
@Component
@Order(1)
public class EmailValidator implements Validator{
    @Override
    public void validate(String email, String password, String name) {
        if (!email.matches("^[a-z0-9]+\\@[a-z0-9]+\\.[a-z]{2,10}$")) {
            throw new IllegalArgumentException("invalid email: " + email);
        }
    }
}
