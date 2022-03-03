package com.pengo.spring.ioc;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author pengo
 * @description:
 * @date 2022/3/1 11:35
 */
@Component
@Order(3)
public class PasswordValidator implements Validator{
    @Override
    public void validate(String email, String password, String name) {
        if (!password.matches("^.{6,20}$")) {
            throw new IllegalArgumentException("invalid password");
        }
    }
}
