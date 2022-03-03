package com.pengo.spring.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author pengo
 * @description:
 * @date 2022/3/1 11:37
 */
@Component
public class Validators {
    @Autowired
    List<Validator> validators;

    public void validate(String email, String password, String name) {
        for (Validator validator : validators) {
            validator.validate(email, password, name);
        }
    }
}
