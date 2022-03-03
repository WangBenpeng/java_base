package com.pengo.spring.ioc;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author pengo
 * @description:
 * @date 2022/3/1 11:36
 */
@Component
@Order(2)
public class NameValidator implements Validator{
    @Override
    public void validate(String email, String password, String name) {
        if (name == null || name.isBlank() || name.length() > 20) {
            throw new IllegalArgumentException("invalid name: " + name);
        }
    }
}
